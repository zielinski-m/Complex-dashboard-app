package com.melon.dashboard.controller;

import com.melon.dashboard.model.PipedriveUser;
import com.melon.dashboard.model.PipedriveUserDto;
import com.melon.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DashboardController {
    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(
            @RequestParam(value = "filterByName", required = false) String filterByName,
            @RequestParam(value = "sortBy", required = false)String sortBy,
            Model model) {
        List<PipedriveUserDto> users = dashboardService.getAggregatedUserData();
        users = dashboardService.filterByName(users, filterByName);
        users = dashboardService.sortBy(users, sortBy);

        // Przygotowanie danych dla Chart.js (np. lista nazw użytkowników i ilość dealów)
        List<String> userNames = users.stream().map(PipedriveUserDto::getName).collect(Collectors.toList());
        List<Integer> userDeals = users.stream().map(PipedriveUserDto::getDealsCount).collect(Collectors.toList());

        model.addAttribute("userNames", userNames);
        model.addAttribute("userDeals", userDeals);
        model.addAttribute("filterByName", filterByName);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("users", users);
        return "dashboard";
    }
}
