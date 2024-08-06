package com.example.gms_backend.repository;

import com.example.gms_backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MemberServiceRepository extends JpaRepository<MemberService, String> {
    List<MemberService> findByMembership(Membership membership);
    List<MemberService> findByPersonalTrainerPackage(PersonalTrainerPackage trainerPackage);
    List<MemberService> findByCoachAndStatus(Coach coach, String status);
    MemberService findByCoachAndMemberAndStatus(Coach coach, Member member, String status);

    @Query("SELECT ms FROM MemberService ms WHERE ms.member.id = :memberId AND ms.membership IS NOT NULL ORDER BY ms.createdAt DESC")
    List<MemberService> findByMemberIdAndMembershipIsNotNullOrderByCreatedAtDesc(@Param("memberId") String memberId);

    @Query("SELECT ms FROM MemberService ms WHERE ms.member.id = :memberId AND ms.personalTrainerPackage IS NOT NULL ORDER BY ms.createdAt DESC")
    List<MemberService> findByMemberIdAndPTServiceIsNotNullOrderByCreatedAtDesc(@Param("memberId") String memberId);

    @Query("SELECT ms.member FROM MemberService ms WHERE ms.member.gym.id = :gymId " +
            "AND ms.membership IS NOT NULL " +
            "AND ms.status != 'Expired' " +
            "AND :dateClass BETWEEN ms.startDate AND ms.endDate")
    List<Member> getListAvailableMemberForAddToClass(@Param("gymId") String gymId,
                                                     @Param("dateClass") Date dateClass);

    @Query("SELECT COUNT(ms) FROM MemberService ms WHERE (:gymId = 'all' OR ms.member.gym.id = :gymId) " +
            "AND ms.membership IS NOT NULL " +
            "AND ms.status != 'Expired'")
    int getNumAvailableMember(@Param("gymId") String gymId);

    @Query("SELECT COUNT(ms) FROM MemberService ms WHERE (:gymId = 'all' OR ms.member.gym.id = :gymId) " +
            "AND ms.membership.id = :membershipId " +
            "AND ms.status != 'Expired'")
    int getNumMemberByMembershipPackage(@Param("gymId") String gymId,
                                        @Param("membershipId") String membershipId);

    @Query("SELECT COUNT(ms) FROM MemberService ms WHERE ms.coach.id = :coachId")
    int getNumMemberOfCoach(@Param("coachId") String coachId);
}
