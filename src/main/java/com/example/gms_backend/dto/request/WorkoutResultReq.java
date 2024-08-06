package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutResultReq {
    private Integer numWeeks;
    private String imageUrl;
    private String preIssues;
    private String shareContent;
    private String description;
    private String measurement;
    private String programDescription;
    private String nutritionPlan;
}
