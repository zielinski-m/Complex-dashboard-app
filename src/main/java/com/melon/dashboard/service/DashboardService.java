package com.melon.dashboard.service;

import com.melon.dashboard.model.PipedriveUser;
import com.melon.dashboard.model.PipedriveUserDto;

import java.util.List;

public interface DashboardService {
    List<PipedriveUserDto> getAggregatedUserData();
    List<PipedriveUserDto> filterByName(List<PipedriveUserDto> users, String filterByName);
    List<PipedriveUserDto> sortBy(List<PipedriveUserDto> users, String sortBy);
}
