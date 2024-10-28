package com.melon.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PipedriveResponse {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("data")
    private List<PipedriveUser> data;
}
