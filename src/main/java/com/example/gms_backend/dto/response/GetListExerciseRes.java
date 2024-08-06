package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.ExerciseLibrary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListExerciseRes {
    private List<ExerciseLibrary> listExercises;
    private int numExercises;
}
