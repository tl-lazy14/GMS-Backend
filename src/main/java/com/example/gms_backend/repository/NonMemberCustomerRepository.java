package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.NonMemberCustomer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface NonMemberCustomerRepository extends JpaRepository<NonMemberCustomer, String> {
    @Query("SELECT u FROM NonMemberCustomer u WHERE (:gymId = 'all' OR u.gym.id = :gymId) " +
            "AND FUNCTION('DATE', u.checkInTime) = :date " +
            "AND (u.name LIKE %:keyword% OR u.phone LIKE %:keyword%) " +
            "ORDER BY u.createdAt DESC")
    List<NonMemberCustomer> getListNonMemCustomer(@Param("gymId") String gymId,
                                                  @Param("date") Date date,
                                                  @Param("keyword") String keyword,
                                                  Pageable pageable);

    @Query("SELECT COUNT(u) FROM NonMemberCustomer u WHERE (:gymId = 'all' OR u.gym.id = :gymId) " +
            "AND FUNCTION('DATE', u.checkInTime) = :date " +
            "AND (u.name LIKE %:keyword% OR u.phone LIKE %:keyword%)")
    int countListNonMemCustomer(@Param("gymId") String gymId,
                                @Param("date") Date date,
                                @Param("keyword") String keyword);

    @Query("SELECT u FROM NonMemberCustomer u WHERE (:gymId = 'all' OR u.gym.id = :gymId) " +
            "AND FUNCTION('DATE', u.checkInTime) = :date " +
            "ORDER BY u.createdAt DESC")
    List<NonMemberCustomer> exportListNonMemCustomer(@Param("gymId") String gymId,
                                                     @Param("date") Date date);

    @Query("SELECT COUNT(u) FROM NonMemberCustomer u WHERE (:gymId = 'all' OR u.gym.id = :gymId)")
    int countTotalNonMemCustomer(@Param("gymId") String gymId);

    @Query("SELECT COUNT(m) FROM NonMemberCustomer m WHERE (:gymId = 'all' OR m.gym.id = :gymId) " +
            "AND YEAR(m.createdAt) = :year AND MONTH(m.createdAt) = :month")
    int countNonMemCustomersByMonth(@Param("gymId") String gymId,
                                    @Param("year") int year,
                                    @Param("month") int month);
}
