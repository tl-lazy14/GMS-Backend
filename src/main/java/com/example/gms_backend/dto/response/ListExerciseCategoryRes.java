package com.example.gms_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListExerciseCategoryRes {
    private String id;
    private String name;
    private Integer numVideos;
}
