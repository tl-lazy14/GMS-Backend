package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymRepository extends JpaRepository<Gym, String> {
    List<Gym> findAllByOrderByCreatedAtDesc();
    List<Gym> findByStatusOrderByCreatedAtDesc(String status);
}
