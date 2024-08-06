package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.BenefitReq;
import com.example.gms_backend.dto.request.CUMembershipPackageReq;
import com.example.gms_backend.dto.request.MemPackageListBenefitDTO;
import com.example.gms_backend.dto.request.PTPackageReq;
import com.example.gms_backend.dto.response.MembershipPackageRes;
import com.example.gms_backend.dto.response.PTPackageRes;
import com.example.gms_backend.entity.Benefit;
import com.example.gms_backend.entity.Membership;
import com.example.gms_backend.entity.PersonalTrainerPackage;

import java.util.List;

public interface PackageService {
    List<MembershipPackageRes> getListMembershipPackage();
    List<MembershipPackageRes> getListActiveMembershipPackageWithBenefit();
    List<Membership> getListActiveMembershipPackage();
    void addMembershipPackage(CUMembershipPackageReq request);
    void editMembershipPackage(String id, CUMembershipPackageReq request);
    void deleteMembershipPackage(String id);
    List<Benefit> getAllBenefit();
    void addBenefit(BenefitReq request);
    void editBenefit(String id, BenefitReq request);
    void deleteBenefit(String id);
    void updateMembershipBenefit(List<MemPackageListBenefitDTO> packages);
    List<PTPackageRes> getListPTPackage();
    List<PersonalTrainerPackage> getListActivePTPackage();
    void addPTPackage(PTPackageReq request);
    void editPTPackage(String id, PTPackageReq request);
    void deletePTPackage(String id);
    List<Membership> getListPackageBetter(String id);
}
