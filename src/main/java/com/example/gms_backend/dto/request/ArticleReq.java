package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleReq {
    private String title;
    private String thumbnail;
    private String content;
    private String category;
    private String tags;
    private String status;
}
