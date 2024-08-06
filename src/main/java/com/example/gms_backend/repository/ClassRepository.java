package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Class;
import com.example.gms_backend.entity.ClassCategory;
import com.example.gms_backend.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, String> {
    List<Class> findByClassCategory(ClassCategory classCategory);
    List<Class> findByGymAndClassCategory(Gym gym, ClassCategory category);

    @Query("SELECT COUNT(u) FROM Class u WHERE u.coach.id = :coachId")
    int getNumClassesOfCoach(@Param("coachId") String coachId);
}
