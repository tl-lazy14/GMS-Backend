package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.Coach;
import com.example.gms_backend.entity.Gym;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, String> {
    @Query("SELECT u FROM Coach u WHERE (:level = 'all' OR u.level = :level) " +
            "AND (:status = 'all' OR u.status = :status) " +
            "AND (:gym = 'all' OR u.gym.id = :gym) " +
            "AND (u.code LIKE %:keyword% OR u.name LIKE %:keyword%) " +
            "ORDER BY u.createdAt DESC")
    List<Coach> getListCoach(@Param("level") String level,
                             @Param("status") String status,
                             @Param("gym") String gym,
                             @Param("keyword") String keyword,
                             Pageable pageable);

    @Query("SELECT COUNT(u) FROM Coach u WHERE (:level = 'all' OR u.level = :level) " +
            "AND (:status = 'all' OR u.status = :status) " +
            "AND (:gym = 'all' OR u.gym.id = :gym) " +
            "AND (u.code LIKE %:keyword% OR u.name LIKE %:keyword%)")
    int countListCoach(@Param("level") String level,
                       @Param("status") String status,
                       @Param("gym") String gym,
                       @Param("keyword") String keyword);

    List<Coach> findByGymAndStatusOrderByCreatedAtDesc(Gym gym, String status);

    List<Coach> findByStatus(String status);

    @Query("SELECT COUNT(u) FROM Coach u WHERE (:gymId = 'all' OR u.gym.id = :gymId) " +
            "AND u.status = 'Active'")
    int countTotalCoach(@Param("gymId") String gymId);

    @Query("SELECT COUNT(u) FROM Coach u WHERE (:gymId = 'all' OR u.gym.id = :gymId) " +
            "AND u.level = :level AND u.status = 'Active'")
    int getNumCoachByLevel(@Param("gymId") String gymId,
                           @Param("level") String level);

    @Query("SELECT u FROM Coach u WHERE (:gymId = 'all' OR u.gym.id = :gymId) " +
            "AND u.status = 'Active'")
    List<Coach> getListTotalActiveCoach(@Param("gymId") String gymId);
}
