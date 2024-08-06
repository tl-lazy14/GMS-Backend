package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Class;
import com.example.gms_backend.entity.Coach;
import com.example.gms_backend.entity.CoachSchedule;
import com.example.gms_backend.entity.MemberService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoachScheduleRepository extends JpaRepository<CoachSchedule, String> {
    List<CoachSchedule> findByCoach(Coach coach);
    List<CoachSchedule> findByCoachAndType(Coach coach, String type);
    List<CoachSchedule> findByMemberServiceOrderByStartDateAsc(MemberService memberService);
    @Query("SELECT u FROM CoachSchedule u WHERE u.aClass.id = :classId")
    CoachSchedule findByClass(@Param("classId") String classId);
    @Query("SELECT u FROM CoachSchedule u WHERE u.memberService.member.id = :memberId")
    List<CoachSchedule> findByMember(@Param("memberId") String memberId);
}
