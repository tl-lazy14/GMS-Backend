package com.example.gms_backend.repository;

import com.example.gms_backend.entity.ClassMember;
import com.example.gms_backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassMemberRepository extends JpaRepository<ClassMember, String> {
    List<ClassMember> findByMember(Member member);
    @Query("SELECT u FROM ClassMember u WHERE u.aClass.id = :classId")
    List<ClassMember> findByClass(@Param("classId") String classId);

    @Query("SELECT u FROM ClassMember u WHERE u.aClass.id = :classId AND u.member.id = :memberId")
    ClassMember findByClassAndMember(@Param("classId") String classId,
                                     @Param("memberId") String memberId);
}
