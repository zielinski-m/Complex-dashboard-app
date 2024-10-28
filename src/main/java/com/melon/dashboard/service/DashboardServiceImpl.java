package com.melon.dashboard.service;

import com.melon.dashboard.model.PipedriveUser;
import com.melon.dashboard.model.PipedriveUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final PipedriveService pipedriveService;

    @Autowired
    public DashboardServiceImpl(PipedriveService pipedriveService) {
        this.pipedriveService = pipedriveService;
    }

    @Override
    public List<PipedriveUserDto> getAggregatedUserData() {
        List<PipedriveUser> users = pipedriveService.getUsers();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PipedriveUserDto convertToDto(PipedriveUser user) {
        PipedriveUserDto dto = new PipedriveUserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }


    @Override
    public List<PipedriveUserDto> filterByName(List<PipedriveUserDto> users, String filterByName) {
        if (filterByName == null || filterByName.isEmpty()) {
            return users;
        }
        return users.stream()
                .filter(user -> user.getName().toLowerCase().contains(filterByName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PipedriveUserDto> sortBy(List<PipedriveUserDto> users, String sortBy) {
        if (sortBy == null || sortBy.isEmpty()) {
            return users;
        }
        switch (sortBy) {
            case "name":
                return users.stream()
                        .sorted(Comparator.comparing(PipedriveUserDto::getName))
                        .collect(Collectors.toList());
            case "dealCount":
                return users.stream()
                        .sorted(Comparator.comparingInt(PipedriveUserDto::getDealsCount))
                        .collect(Collectors.toList());
            default:
                return users;
        }
    }
}
