package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.Coach;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListCoachRes {
    private List<Coach> listItem;
    private int numItem;
}
