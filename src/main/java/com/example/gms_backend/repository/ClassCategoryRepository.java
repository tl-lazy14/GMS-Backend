package com.example.gms_backend.repository;

import com.example.gms_backend.entity.ClassCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassCategoryRepository extends JpaRepository<ClassCategory, String> {
    Optional<ClassCategory> findByName(String name);
}
