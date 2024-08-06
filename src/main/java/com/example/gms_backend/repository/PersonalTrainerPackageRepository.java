package com.example.gms_backend.repository;

import com.example.gms_backend.entity.PersonalTrainerPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalTrainerPackageRepository extends JpaRepository<PersonalTrainerPackage, String> {
    List<PersonalTrainerPackage> findAllByOrderByPriceAsc();
    List<PersonalTrainerPackage> findByStatusOrderByPriceAsc(String status);
}
