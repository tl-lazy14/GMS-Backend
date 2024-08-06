package com.example.gms_backend.repository;

import com.example.gms_backend.entity.MemberRegistrationTransfer;
import com.example.gms_backend.entity.NonMemberCustomer;
import com.example.gms_backend.entity.TrialRegistration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TrialRegistrationRepository extends JpaRepository<TrialRegistration, String> {
    @Query("SELECT u FROM TrialRegistration u WHERE (:contactStatus = 'all' OR u.statusContact = :contactStatus) " +
            "AND (:approvalStatus = 'all' OR u.statusApprove = :approvalStatus) " +
            "AND u.gym.id = :gymId " +
            "AND (u.name LIKE %:keyword% OR u.phone LIKE %:keyword%) " +
            "ORDER BY u.createdAt DESC")
    List<TrialRegistration> getList(@Param("contactStatus") String contactStatus,
                                    @Param("approvalStatus") String approvalStatus,
                                    @Param("gymId") String gymId,
                                    @Param("keyword") String keyword,
                                    Pageable pageable);

    @Query("SELECT COUNT(u) FROM TrialRegistration u WHERE (:contactStatus = 'all' OR u.statusContact = :contactStatus) " +
            "AND (:approvalStatus = 'all' OR u.statusApprove = :approvalStatus) " +
            "AND u.gym.id = :gymId " +
            "AND (u.name LIKE %:keyword% OR u.phone LIKE %:keyword%)")
    int countList(@Param("contactStatus") String contactStatus,
                  @Param("approvalStatus") String approvalStatus,
                  @Param("gymId") String gymId,
                  @Param("keyword") String keyword);

    @Query("SELECT u FROM TrialRegistration u WHERE (:contactStatus = 'all' OR u.statusContact = :contactStatus) " +
            "AND (:approvalStatus = 'all' OR u.statusApprove = :approvalStatus) " +
            "AND u.gym.id = :gymId " +
            "ORDER BY u.createdAt DESC")
    List<TrialRegistration> exportList(@Param("contactStatus") String contactStatus,
                                       @Param("approvalStatus") String approvalStatus,
                                       @Param("gymId") String gymId);
}
