package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassReq {
    private String title;
    private String categoryId;
    private String coachId;
    private String startDate;
    private String endDate;
    private int maxParticipants;
    private String description;
    private String gymId;
}
