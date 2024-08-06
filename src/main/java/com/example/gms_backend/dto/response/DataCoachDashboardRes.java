package com.example.gms_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataCoachDashboardRes {
    private String id;
    private String code;
    private String name;
    private String level;
    private int numMembersTrained;
    private int numClassesTaught;
}
