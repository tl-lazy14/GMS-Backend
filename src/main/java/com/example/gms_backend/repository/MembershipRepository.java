package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Benefit;
import com.example.gms_backend.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, String> {
    List<Membership> findAllByOrderByPriceMonthAsc();
    List<Membership> findAllByOrderByPriceMonthDesc();
    List<Membership> findByStatusOrderByPriceMonthAsc(String status);
    @Query("SELECT m FROM Membership m WHERE m.priceMonth > :priceMonth AND m.status = 'Active' " +
            "ORDER BY m.priceMonth ASC ")
    List<Membership> findBetterMembership(@Param("priceMonth") Double priceMonth);
}
