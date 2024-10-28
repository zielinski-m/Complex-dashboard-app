package com.melon.dashboard.service;

import com.melon.dashboard.model.PipedriveUser;

import java.util.List;

public interface PipedriveService {
    List<PipedriveUser> getUsers();
}
