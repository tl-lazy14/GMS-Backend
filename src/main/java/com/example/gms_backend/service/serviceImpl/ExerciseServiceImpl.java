package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.ExerciseReq;
import com.example.gms_backend.dto.request.GetListExercisesReq;
import com.example.gms_backend.dto.response.GetListExerciseRes;
import com.example.gms_backend.dto.response.ListExerciseCategoryRes;
import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.ExerciseCategory;
import com.example.gms_backend.entity.ExerciseLibrary;
import com.example.gms_backend.repository.ExerciseCategoryRepository;
import com.example.gms_backend.repository.ExerciseLibraryRepository;
import com.example.gms_backend.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseCategoryRepository exerciseCategoryRepository;
    private final ExerciseLibraryRepository exerciseLibraryRepository;

    @Override
    public List<ListExerciseCategoryRes> getAllExerciseCategories() {
        List<ExerciseCategory> exerciseCategoryList = exerciseCategoryRepository.findAll();

        List<ListExerciseCategoryRes> res = new ArrayList<>();
        for (ExerciseCategory category : exerciseCategoryList) {
            List<ExerciseLibrary> listExercisesofCategory = exerciseLibraryRepository.findByExerciseCategory(category);

            ListExerciseCategoryRes categoryRes = ListExerciseCategoryRes.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .numVideos(listExercisesofCategory.size())
                    .build();
            res.add(categoryRes);
        }
        return res;
    }

    @Override
    public void addExerciseCategory(String name) {
        Optional<ExerciseCategory> categoryExist = exerciseCategoryRepository.findByName(name);
        if (categoryExist.isPresent()) {
            throw new RuntimeException("Category name already exists!");
        }
        ExerciseCategory newCategory = new ExerciseCategory();
        newCategory.setName(name);
        newCategory.setCreatedAt(new Date());
        newCategory.setUpdatedAt(new Date());
        exerciseCategoryRepository.save(newCategory);
    }

    @Override
    public void editExerciseCategory(String id, String name) {
        ExerciseCategory exerciseCategory = exerciseCategoryRepository.findById(id).orElseThrow();

        Optional<ExerciseCategory> categoryExist = exerciseCategoryRepository.findByName(name);
        if (categoryExist.isPresent() && !categoryExist.get().getId().equals(id)) {
            throw new RuntimeException("Category name already exists!");
        }
        exerciseCategory.setName(name);
        exerciseCategory.setUpdatedAt(new Date());
        exerciseCategoryRepository.save(exerciseCategory);
    }

    @Override
    public void deleteExerciseCategory(String id) {
        ExerciseCategory exerciseCategory = exerciseCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
        exerciseCategoryRepository.delete(exerciseCategory);
    }

    @Override
    public GetListExerciseRes getListExercises(GetListExercisesReq request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, 9);
        List<ExerciseLibrary> listExercise = exerciseLibraryRepository.getListExercises(
                request.getCategory(),
                request.getLevel(),
                request.getKeyword(),
                pageable);
        int numExercises = exerciseLibraryRepository.countListExercises(
                request.getCategory(),
                request.getLevel(),
                request.getKeyword());
        return GetListExerciseRes.builder()
                .listExercises(listExercise)
                .numExercises(numExercises)
                .build();
    }

    @Override
    public ExerciseLibrary getExercise(String id) {
        return exerciseLibraryRepository.findById(id).orElseThrow();
    }

    @Override
    public void addExercise(ExerciseReq request) {
        ExerciseLibrary newExercise = new ExerciseLibrary();
        newExercise.setTitle(request.getTitle());
        newExercise.setDescription(request.getDescription());
        newExercise.setThumbnail(request.getThumbnail());
        newExercise.setYoutubeUrl(request.getUrl());
        ExerciseCategory category = exerciseCategoryRepository.findById(request.getCategoryId()).orElseThrow();
        newExercise.setExerciseCategory(category);
        newExercise.setLevel(request.getLevel());
        newExercise.setCreatedAt(new Date());
        newExercise.setUpdatedAt(new Date());
        exerciseLibraryRepository.save(newExercise);
    }

    @Override
    public void editExercise(String id, ExerciseReq request) {
        ExerciseLibrary exercise = exerciseLibraryRepository.findById(id).orElseThrow();
        exercise.setTitle(request.getTitle());
        exercise.setDescription(request.getDescription());
        exercise.setThumbnail(request.getThumbnail());
        exercise.setYoutubeUrl(request.getUrl());
        ExerciseCategory category = exerciseCategoryRepository.findById(request.getCategoryId()).orElseThrow();
        exercise.setExerciseCategory(category);
        exercise.setLevel(request.getLevel());
        exercise.setUpdatedAt(new Date());
        exerciseLibraryRepository.save(exercise);
    }

    @Override
    public void deleteExercise(String id) {
        ExerciseLibrary exercise = exerciseLibraryRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found!"));
        exerciseLibraryRepository.delete(exercise);
    }
}
