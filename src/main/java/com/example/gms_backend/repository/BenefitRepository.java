package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenefitRepository extends JpaRepository<Benefit, String> {
    List<Benefit> findAllByOrderByCreatedAtDesc();
}
