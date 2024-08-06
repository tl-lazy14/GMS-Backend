package com.example.gms_backend.repository;

import com.example.gms_backend.entity.EquipmentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentCategoryRepository extends JpaRepository<EquipmentCategory, String> {
    List<EquipmentCategory> findAllByOrderByCreatedAtDesc();
}
