package com.example.gms_backend.repository;

import com.example.gms_backend.entity.Benefit;
import com.example.gms_backend.entity.Membership;
import com.example.gms_backend.entity.MembershipBenefit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipBenefitRepository extends JpaRepository<MembershipBenefit, String> {
    MembershipBenefit findByMembershipAndBenefit(Membership membership, Benefit benefit);
}
