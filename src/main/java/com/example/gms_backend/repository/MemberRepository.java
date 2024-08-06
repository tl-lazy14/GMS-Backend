package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Gym;
import com.example.gms_backend.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findByGymOrderByCreatedAtDesc(Gym gym);
    @Query("SELECT m FROM Member m WHERE m.gym.id = :gymId " +
            "AND (m.code LIKE %:keyword% OR m.name LIKE %:keyword% OR m.email LIKE %:keyword% OR m.phone LIKE %:keyword%) " +
            "ORDER BY m.createdAt DESC ")
    List<Member> searchByKeywordAndGym(@Param("gymId") String gymId, @Param("keyword") String keyword);

    @Query("SELECT COUNT(m) FROM Member m WHERE (:gymId = 'all' OR m.gym.id = :gymId) " +
            "AND YEAR(m.createdAt) = :year AND MONTH(m.createdAt) = :month")
    int countNewMembersByMonth(@Param("gymId") String gymId,
                               @Param("year") int year,
                               @Param("month") int month);

    @Query("SELECT m FROM Member m WHERE FUNCTION('DATE', m.createdAt) = FUNCTION('DATE', :currentDate) " +
            "AND (:gymId = 'all' OR m.gym.id = :gymId) ORDER BY m.createdAt DESC")
    List<Member> findNewMembersToday(@Param("currentDate") Date currentDate,
                                    @Param("gymId") String gymId);
}
