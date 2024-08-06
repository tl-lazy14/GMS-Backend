package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.MemberRegistrationTransfer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRegistrationTransferRepository extends JpaRepository<MemberRegistrationTransfer, String> {
    @Query("SELECT u FROM MemberRegistrationTransfer u WHERE (:membershipId = 'all' OR u.membership.id = :membershipId) " +
            "AND (:status = 'all' OR u.status = :status) " +
            "AND u.gym.id = :gymId " +
            "AND (u.name LIKE %:keyword% OR u.email LIKE %:keyword% OR u.phone LIKE %:keyword%) " +
            "ORDER BY u.createdAt DESC")
    List<MemberRegistrationTransfer> getList(@Param("membershipId") String membershipId,
                                             @Param("status") String status,
                                             @Param("gymId") String gymId,
                                             @Param("keyword") String keyword,
                                             Pageable pageable);

    @Query("SELECT COUNT(u) FROM MemberRegistrationTransfer u WHERE (:membershipId = 'all' OR u.membership.id = :membershipId) " +
            "AND (:status = 'all' OR u.status = :status) " +
            "AND u.gym.id = :gymId " +
            "AND (u.name LIKE %:keyword% OR u.email LIKE %:keyword% OR u.phone LIKE %:keyword%)")
    int countList(@Param("membershipId") String membershipId,
                  @Param("status") String status,
                  @Param("gymId") String gymId,
                  @Param("keyword") String keyword);
}
