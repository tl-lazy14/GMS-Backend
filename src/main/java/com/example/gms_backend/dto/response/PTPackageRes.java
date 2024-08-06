package com.example.gms_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PTPackageRes {
    private String id;
    private String name;
    private Integer duration;
    private Integer numSessions;
    private Double price;
    private String status;
    private Long numRegistrations;
}
