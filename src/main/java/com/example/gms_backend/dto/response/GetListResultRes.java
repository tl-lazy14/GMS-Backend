package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.WorkoutResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListResultRes {
    private List<WorkoutResult> listItem;
    private int numItem;
}
