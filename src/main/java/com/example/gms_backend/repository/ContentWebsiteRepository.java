package com.example.gms_backend.repository;

import com.example.gms_backend.entity.ContentWebsite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentWebsiteRepository extends JpaRepository<ContentWebsite, String> {
    List<ContentWebsite> findAllByTypeOrderByCreatedAtAsc(String type);
    List<ContentWebsite> findAllByTypeAndPageOrderByCreatedAtDesc(String type, String page);
    ContentWebsite findByTypeAndTitle(String type, String title);
}
