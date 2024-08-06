package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RevenueRepository extends JpaRepository<Revenue, String> {
    @Query("SELECT u FROM Revenue u WHERE u.month = :month AND u.year = :year AND u.gym.id = :gymId")
    Optional<Revenue> findByMonthAndYear(Integer year, Integer month, String gymId);

    @Query("SELECT COALESCE(SUM(r.membershipRevenue + r.ptServiceRevenue + r.nonMemRevenue), 0) " +
            "FROM Revenue r " +
            "WHERE (:gymId = 'all' OR r.gym.id = :gymId)")
    Double getTotalRevenue(@Param("gymId") String gymId);

    @Query("SELECT COALESCE(SUM(r.membershipRevenue), 0) FROM Revenue r " +
            "WHERE (:gymId = 'all' OR r.gym.id = :gymId) " +
            "AND r.year = :year AND r.month = :month")
    Double getMembershipRevenueByMonth(@Param("gymId") String gymId,
                                       @Param("year") int year,
                                       @Param("month") int month);

    @Query("SELECT COALESCE(SUM(r.ptServiceRevenue), 0) FROM Revenue r " +
            "WHERE (:gymId = 'all' OR r.gym.id = :gymId) " +
            "AND r.year = :year AND r.month = :month")
    Double getPTServiceRevenueByMonth(@Param("gymId") String gymId,
                                      @Param("year") int year,
                                      @Param("month") int month);

    @Query("SELECT COALESCE(SUM(r.nonMemRevenue), 0) FROM Revenue r " +
            "WHERE (:gymId = 'all' OR r.gym.id = :gymId) " +
            "AND r.year = :year AND r.month = :month")
    Double getNonMemCustomerRevenueByMonth(@Param("gymId") String gymId,
                                           @Param("year") int year,
                                           @Param("month") int month);

    @Query("SELECT COALESCE(SUM(r.membershipRevenue + r.ptServiceRevenue + r.nonMemRevenue), 0) FROM Revenue r " +
            "WHERE (:gymId = 'all' OR r.gym.id = :gymId) " +
            "AND r.year = :year AND r.month = :month")
    Double getTotalRevenueByMonth(@Param("gymId") String gymId,
                                  @Param("year") int year,
                                  @Param("month") int month);
}
