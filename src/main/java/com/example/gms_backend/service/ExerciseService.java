package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.ExerciseReq;
import com.example.gms_backend.dto.request.GetListExercisesReq;
import com.example.gms_backend.dto.response.GetListExerciseRes;
import com.example.gms_backend.dto.response.ListExerciseCategoryRes;
import com.example.gms_backend.entity.ExerciseLibrary;

import java.util.List;

public interface ExerciseService {
    List<ListExerciseCategoryRes> getAllExerciseCategories();
    void addExerciseCategory(String name);
    void editExerciseCategory(String id, String name);
    void deleteExerciseCategory(String id);
    GetListExerciseRes getListExercises(GetListExercisesReq request);
    void addExercise(ExerciseReq request);
    void editExercise(String id, ExerciseReq request);
    void deleteExercise(String id);
    ExerciseLibrary getExercise(String id);
}
