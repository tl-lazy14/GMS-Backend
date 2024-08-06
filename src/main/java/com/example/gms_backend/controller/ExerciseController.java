package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.CategoryReq;
import com.example.gms_backend.dto.request.ExerciseReq;
import com.example.gms_backend.dto.request.GetListExercisesReq;
import com.example.gms_backend.dto.response.ErrorRes;
import com.example.gms_backend.dto.response.GetListExerciseRes;
import com.example.gms_backend.dto.response.ListExerciseCategoryRes;
import com.example.gms_backend.entity.ExerciseLibrary;
import com.example.gms_backend.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping("/get-list-category")
    public ResponseEntity<List<ListExerciseCategoryRes>> getListExerciseCategory() {
        List<ListExerciseCategoryRes> response = exerciseService.getAllExerciseCategories();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-category")
    public ResponseEntity<?> addExerciseCategory(@RequestBody CategoryReq request) {
        try {
            exerciseService.addExerciseCategory(request.getName());
            return ResponseEntity.ok().body("Success");
        } catch (Exception e) {
            ErrorRes errorResponse = ErrorRes.builder().error(e.getMessage()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/edit-category/{id}")
    public ResponseEntity<?> editExerciseCategory(@PathVariable(value = "id") String id,
                                                  @RequestBody CategoryReq request) {
        try {
            exerciseService.editExerciseCategory(id, request.getName());
            return ResponseEntity.ok().body("Success");
        } catch (Exception e) {
            ErrorRes errorResponse = ErrorRes.builder().error(e.getMessage()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<String> deleteExerciseCategory(@PathVariable String id) {
        exerciseService.deleteExerciseCategory(id);
        return ResponseEntity.ok("Category deleted successfully!");
    }

    @GetMapping("/get-list-exercise")
    public ResponseEntity<GetListExerciseRes> getListExercises(@RequestParam String category,
                                                               @RequestParam String level,
                                                               @RequestParam String keyword,
                                                               @RequestParam int page) {
        GetListExercisesReq request = new GetListExercisesReq(category, level, keyword, page);
        GetListExerciseRes response = exerciseService.getListExercises(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-exercise/{id}")
    public ResponseEntity<ExerciseLibrary> getExercise(@PathVariable(value = "id") String id) {
        ExerciseLibrary response = exerciseService.getExercise(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-exercise")
    public ResponseEntity<String> addExercise(@RequestBody ExerciseReq request) {
        exerciseService.addExercise(request);
        return ResponseEntity.ok("Exercise created successfully!");
    }

    @PutMapping("/edit-exercise/{id}")
    public ResponseEntity<String> editExercise(@PathVariable(value = "id") String id,
                                               @RequestBody ExerciseReq request) {
        exerciseService.editExercise(id, request);
        return ResponseEntity.ok("Exercise updated successfully!");
    }

    @DeleteMapping("/delete-exercise/{id}")
    public ResponseEntity<String> deleteExercise(@PathVariable String id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.ok("Exercise deleted successfully!");
    }
}
