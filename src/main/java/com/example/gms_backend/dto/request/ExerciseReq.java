package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseReq {
    private String title;
    private String description;
    private String thumbnail;
    private String url;
    private String categoryId;
    private String level;
}
