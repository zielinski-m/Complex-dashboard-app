package com.melon.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PipedriveUserDto {

    private long id;
    private String name;
    private String email;
    private Integer dealsCount;
}
