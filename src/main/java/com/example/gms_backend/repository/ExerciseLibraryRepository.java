package com.example.gms_backend.repository;

import com.example.gms_backend.entity.ExerciseCategory;
import com.example.gms_backend.entity.ExerciseLibrary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseLibraryRepository extends JpaRepository<ExerciseLibrary, String> {
    List<ExerciseLibrary> findByExerciseCategory(ExerciseCategory category);

    @Query("SELECT u FROM ExerciseLibrary u WHERE (:category = 'all' OR u.exerciseCategory.id = :category) AND (:level = 'all' OR u.level = :level) AND u.title LIKE %:keyword% ORDER BY u.createdAt DESC")
    List<ExerciseLibrary> getListExercises(@Param("category") String category,
                                           @Param("level") String level,
                                           @Param("keyword") String keyword,
                                           Pageable pageable);

    @Query("SELECT COUNT(u) FROM ExerciseLibrary u WHERE (:category = 'all' OR u.exerciseCategory.id = :category) AND (:level = 'all' OR u.level = :level) AND u.title LIKE %:keyword%")
    int countListExercises(@Param("category") String category,
                           @Param("level") String level,
                           @Param("keyword") String keyword);
}
