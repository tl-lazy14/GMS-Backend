package com.example.gms_backend.repository;

import com.example.gms_backend.entity.ExerciseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategory, String> {
    Optional<ExerciseCategory> findByName(String name);
}
