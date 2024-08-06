package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.BenefitReq;
import com.example.gms_backend.dto.request.CUMembershipPackageReq;
import com.example.gms_backend.dto.request.MemPackageListBenefitDTO;
import com.example.gms_backend.dto.request.PTPackageReq;
import com.example.gms_backend.dto.response.CheckBenefitIncludeDTO;
import com.example.gms_backend.dto.response.MembershipPackageRes;
import com.example.gms_backend.dto.response.PTPackageRes;
import com.example.gms_backend.entity.*;
import com.example.gms_backend.repository.*;
import com.example.gms_backend.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {
    private final MembershipRepository membershipRepository;
    private final PersonalTrainerPackageRepository personalTrainerPackageRepository;
    private final BenefitRepository benefitRepository;
    private final MembershipBenefitRepository membershipBenefitRepository;
    private final MemberServiceRepository memberServiceRepository;

    @Override
    public List<MembershipPackageRes> getListMembershipPackage() {
        List<Membership> memberships = membershipRepository.findAllByOrderByPriceMonthAsc();

        return memberships.stream().map((membership -> {
            MembershipPackageRes memPackageResponse = new MembershipPackageRes();
            memPackageResponse.setId(membership.getId());
            memPackageResponse.setName(membership.getName());
            memPackageResponse.setDescription(membership.getDescription());
            memPackageResponse.setPriceMonth(membership.getPriceMonth());
            memPackageResponse.setThumbnail(membership.getThumbnail());
            memPackageResponse.setStatus(membership.getStatus());

            List<MemberService> memberServiceList = memberServiceRepository.findByMembership(membership);
            memPackageResponse.setTotalMembers((long) memberServiceList.size());

            List<CheckBenefitIncludeDTO> checkBenefitIncludeDTOList = new ArrayList<>();
            List<Benefit> listBenefit = benefitRepository.findAll();
            for (Benefit benefit : listBenefit) {
                CheckBenefitIncludeDTO benefitIncludeDTO = new CheckBenefitIncludeDTO();
                benefitIncludeDTO.setId(benefit.getId());
                benefitIncludeDTO.setDescription(benefit.getDescription());
                MembershipBenefit membershipBenefit = membershipBenefitRepository.findByMembershipAndBenefit(membership, benefit);
                benefitIncludeDTO.setIncluded(membershipBenefit != null);
                checkBenefitIncludeDTOList.add(benefitIncludeDTO);
            }
            memPackageResponse.setBenefits(checkBenefitIncludeDTOList);
            return memPackageResponse;
        })).toList();
    }

    @Override
    public List<MembershipPackageRes> getListActiveMembershipPackageWithBenefit() {
        List<Membership> memberships = membershipRepository.findByStatusOrderByPriceMonthAsc("Active");

        return memberships.stream().map((membership -> {
            MembershipPackageRes memPackageResponse = new MembershipPackageRes();
            memPackageResponse.setId(membership.getId());
            memPackageResponse.setName(membership.getName());
            memPackageResponse.setDescription(membership.getDescription());
            memPackageResponse.setPriceMonth(membership.getPriceMonth());
            memPackageResponse.setThumbnail(membership.getThumbnail());
            memPackageResponse.setStatus(membership.getStatus());

            List<MemberService> memberServiceList = memberServiceRepository.findByMembership(membership);
            memPackageResponse.setTotalMembers((long) memberServiceList.size());

            List<CheckBenefitIncludeDTO> checkBenefitIncludeDTOList = new ArrayList<>();
            List<Benefit> listBenefit = benefitRepository.findAll();
            for (Benefit benefit : listBenefit) {
                CheckBenefitIncludeDTO benefitIncludeDTO = new CheckBenefitIncludeDTO();
                benefitIncludeDTO.setId(benefit.getId());
                benefitIncludeDTO.setDescription(benefit.getDescription());
                MembershipBenefit membershipBenefit = membershipBenefitRepository.findByMembershipAndBenefit(membership, benefit);
                benefitIncludeDTO.setIncluded(membershipBenefit != null);
                checkBenefitIncludeDTOList.add(benefitIncludeDTO);
            }
            memPackageResponse.setBenefits(checkBenefitIncludeDTOList);
            return memPackageResponse;
        })).toList();
    }

    @Override
    public List<Membership> getListActiveMembershipPackage() {
        return membershipRepository.findByStatusOrderByPriceMonthAsc("Active");
    }

    @Override
    public void addMembershipPackage(CUMembershipPackageReq request) {
        Membership newPackage = new Membership();
        newPackage.setName(request.getName());
        newPackage.setDescription(request.getDescription());
        newPackage.setPriceMonth(request.getPriceMonth());
        newPackage.setThumbnail(request.getThumbnail());
        newPackage.setStatus("Active");
        newPackage.setCreatedAt(new Date());
        newPackage.setUpdatedAt(new Date());
        membershipRepository.save(newPackage);
    }

    @Override
    public void editMembershipPackage(String id, CUMembershipPackageReq request) {
        Membership membershipPackage = membershipRepository.findById(id).orElseThrow();
        membershipPackage.setName(request.getName());
        membershipPackage.setDescription(request.getDescription());
        membershipPackage.setPriceMonth(request.getPriceMonth());
        membershipPackage.setThumbnail(request.getThumbnail());
        membershipPackage.setStatus(request.getStatus());
        membershipPackage.setUpdatedAt(new Date());
        membershipRepository.save(membershipPackage);
    }

    @Override
    public void deleteMembershipPackage(String id) {
        Membership membershipPackage = membershipRepository.findById(id).orElseThrow();
        membershipRepository.delete(membershipPackage);
    }

    @Override
    public List<Benefit> getAllBenefit() {
        return benefitRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public void addBenefit(BenefitReq request) {
        Benefit newBenefit = new Benefit();
        newBenefit.setDescription(request.getDescription());
        newBenefit.setCreatedAt(new Date());
        newBenefit.setUpdatedAt(new Date());
        benefitRepository.save(newBenefit);
    }

    @Override
    public void editBenefit(String id, BenefitReq request) {
        Benefit benefit = benefitRepository.findById(id).orElseThrow();
        benefit.setDescription(request.getDescription());
        benefit.setUpdatedAt(new Date());
        benefitRepository.save(benefit);
    }

    @Override
    public void deleteBenefit(String id) {
        Benefit benefit = benefitRepository.findById(id).orElseThrow();
        benefitRepository.delete(benefit);
    }

    @Override
    public void updateMembershipBenefit(List<MemPackageListBenefitDTO> packages) {
        for (MemPackageListBenefitDTO packageDTO : packages) {
            String membershipId = packageDTO.getId();
            Membership membership = membershipRepository.findById(membershipId).orElseThrow(() -> new RuntimeException("Membership not found"));
            for (CheckBenefitIncludeDTO benefitDTO : packageDTO.getBenefits()) {
                String benefitId = benefitDTO.getId();
                boolean isIncluded = benefitDTO.isIncluded();
                Benefit benefit = benefitRepository.findById(benefitId).orElseThrow(() -> new RuntimeException("Benefit not found"));

                MembershipBenefit membershipBenefit = membershipBenefitRepository.findByMembershipAndBenefit(membership, benefit);
                if (membershipBenefit != null && !isIncluded) {
                    membershipBenefitRepository.delete(membershipBenefit);
                } else if (membershipBenefit == null && isIncluded) {
                    membershipBenefit = new MembershipBenefit();
                    membershipBenefit.setMembership(membership);
                    membershipBenefit.setBenefit(benefit);
                    membershipBenefit.setCreatedAt(new Date());
                    membershipBenefit.setUpdatedAt(new Date());
                    membershipBenefitRepository.save(membershipBenefit);
                }
            }
        }
    }

    @Override
    public List<PTPackageRes> getListPTPackage() {
        List<PTPackageRes> response = new ArrayList<>();

        List<PersonalTrainerPackage> packageList = personalTrainerPackageRepository.findAllByOrderByPriceAsc();
        for (PersonalTrainerPackage trainerPackage : packageList) {
            PTPackageRes res = new PTPackageRes();
            res.setId(trainerPackage.getId());
            res.setName(trainerPackage.getName());
            res.setDuration(trainerPackage.getDuration());
            res.setNumSessions(trainerPackage.getNumSessions());
            res.setPrice(trainerPackage.getPrice());
            res.setStatus(trainerPackage.getStatus());

            List<MemberService> memberServiceList = memberServiceRepository.findByPersonalTrainerPackage(trainerPackage);
            res.setNumRegistrations((long) memberServiceList.size());
            response.add(res);
        }
        return response;
    }

    @Override
    public List<PersonalTrainerPackage> getListActivePTPackage() {
        return personalTrainerPackageRepository.findByStatusOrderByPriceAsc("Active");
    }

    @Override
    public void addPTPackage(PTPackageReq request) {
        PersonalTrainerPackage newPackage = new PersonalTrainerPackage();
        newPackage.setName(request.getName());
        newPackage.setDuration(request.getDuration());
        newPackage.setNumSessions(request.getNumSessions());
        newPackage.setPrice(request.getPrice());
        newPackage.setStatus("Active");
        newPackage.setCreatedAt(new Date());
        newPackage.setUpdatedAt(new Date());
        personalTrainerPackageRepository.save(newPackage);
    }

    @Override
    public void editPTPackage(String id, PTPackageReq request) {
        PersonalTrainerPackage ptPackage = personalTrainerPackageRepository.findById(id).orElseThrow();
        ptPackage.setName(request.getName());
        ptPackage.setDuration(request.getDuration());
        ptPackage.setNumSessions(request.getNumSessions());
        ptPackage.setPrice(request.getPrice());
        ptPackage.setStatus(request.getStatus());
        ptPackage.setUpdatedAt(new Date());
        personalTrainerPackageRepository.save(ptPackage);
    }

    @Override
    public void deletePTPackage(String id) {
        PersonalTrainerPackage ptPackage = personalTrainerPackageRepository.findById(id).orElseThrow();
        personalTrainerPackageRepository.delete(ptPackage);
    }

    @Override
    public List<Membership> getListPackageBetter(String id) {
        Membership membership = membershipRepository.findById(id).orElseThrow();
        return membershipRepository.findBetterMembership(membership.getPriceMonth());
    }
}
