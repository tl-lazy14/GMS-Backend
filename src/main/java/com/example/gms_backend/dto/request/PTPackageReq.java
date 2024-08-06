package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PTPackageReq {
    private String name;
    private Integer duration;
    private Integer numSessions;
    private Double price;
    private String status;
}
