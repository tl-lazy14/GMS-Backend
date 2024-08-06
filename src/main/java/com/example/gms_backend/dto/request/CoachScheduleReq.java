package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoachScheduleReq {
    private String title;
    private String startDate;
    private String endDate;
    private String type;
    private String description;
    private String memberId;
}
