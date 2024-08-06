package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Article;
import com.example.gms_backend.entity.MemberService;
import com.example.gms_backend.entity.WorkoutResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface WorkoutResultRepository extends JpaRepository<WorkoutResult, String> {
    WorkoutResult findByMemberService(MemberService memberService);

    @Query("SELECT u FROM WorkoutResult u WHERE (:gymId = 'all' OR u.gym.id = :gymId) " +
            "AND (:gender = 'All' OR u.memberService.member.gender = :gender) " +
            "AND (u.numWeeks >= :minNumWeeks AND u.numWeeks <= :maxNumWeeks) " +
            "AND (u.memberService.member.code LIKE %:keyword% OR u.memberService.member.name LIKE %:keyword%) " +
            "ORDER BY u.createdAt DESC")
    List<WorkoutResult> getListExceptFilterAge(@Param("gymId") String gymId,
                                               @Param("gender") String gender,
                                               @Param("minNumWeeks") int minNumWeeks,
                                               @Param("maxNumWeeks") int maxNumWeeks,
                                               @Param("keyword") String keyword);
}
