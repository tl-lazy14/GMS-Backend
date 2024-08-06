package com.example.gms_backend.repository;

import com.example.gms_backend.entity.BrandInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandInfoRepository extends JpaRepository<BrandInfo, String> {
    BrandInfo findFirstByOrderByIdAsc();
}
