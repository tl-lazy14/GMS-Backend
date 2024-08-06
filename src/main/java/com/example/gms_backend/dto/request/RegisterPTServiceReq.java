package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPTServiceReq {
    private String packageId;
    private String startDate;
    private String endDate;
    private Double cost;
}
