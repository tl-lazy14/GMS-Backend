package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.MembershipPackageRes;
import com.example.gms_backend.dto.response.PTPackageRes;
import com.example.gms_backend.entity.Benefit;
import com.example.gms_backend.entity.ContentWebsite;
import com.example.gms_backend.entity.Membership;
import com.example.gms_backend.entity.PersonalTrainerPackage;
import com.example.gms_backend.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class PackageController {
    private final PackageService packageService;

    @GetMapping("/get-all-membership-package")
    public ResponseEntity<List<MembershipPackageRes>> getAllMembershipPackage() {
        List<MembershipPackageRes> response = packageService.getListMembershipPackage();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-active-membership-package-with-benefit")
    public ResponseEntity<List<MembershipPackageRes>> getListActiveMembershipPackageWithBenefit() {
        List<MembershipPackageRes> response = packageService.getListActiveMembershipPackageWithBenefit();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-active-membership-package")
    public ResponseEntity<List<Membership>> getListActiveMembershipPackage() {
        List<Membership> response = packageService.getListActiveMembershipPackage();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-membership-package")
    public void addMembershipPackage(@RequestBody CUMembershipPackageReq request) {
        packageService.addMembershipPackage(request);
    }

    @PutMapping("/edit-membership-package/{id}")
    public void editMembershipPackage(@PathVariable(value = "id") String id, @RequestBody CUMembershipPackageReq request) {
        packageService.editMembershipPackage(id, request);
    }

    @DeleteMapping("/delete-membership-package/{id}")
    public void deleteMembershipPackage(@PathVariable(value = "id") String id) {
        packageService.deleteMembershipPackage(id);
    }

    @GetMapping("/get-all-benefit")
    public ResponseEntity<List<Benefit>> getAllBenefit() {
        List<Benefit> response = packageService.getAllBenefit();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-benefit")
    public void addBenefit(@RequestBody BenefitReq request) {
        packageService.addBenefit(request);
    }

    @PutMapping("/edit-benefit/{id}")
    public void editBenefit(@PathVariable(value = "id") String id, @RequestBody BenefitReq request) {
        packageService.editBenefit(id, request);
    }

    @DeleteMapping("/delete-benefit/{id}")
    public void deleteBenefit(@PathVariable(value = "id") String id) {
        packageService.deleteBenefit(id);
    }

    @PutMapping("/update-benefit-membership")
    public void updateBenefitMembership(@RequestBody List<MemPackageListBenefitDTO> extractedData) {
        packageService.updateMembershipBenefit(extractedData);
    }

    @GetMapping("/get-all-pt-package")
    public ResponseEntity<List<PTPackageRes>> getAllPTPackage() {
        List<PTPackageRes> response = packageService.getListPTPackage();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-active-pt-package")
    public ResponseEntity<List<PersonalTrainerPackage>> getListActivePTPackage() {
        List<PersonalTrainerPackage> response = packageService.getListActivePTPackage();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-pt-package")
    public void addPTPackage(@RequestBody PTPackageReq request) {
        packageService.addPTPackage(request);
    }

    @PutMapping("/edit-pt-package/{id}")
    public void editPTPackage(@PathVariable(value = "id") String id, @RequestBody PTPackageReq request) {
        packageService.editPTPackage(id, request);
    }

    @DeleteMapping("/delete-pt-package/{id}")
    public void deletePTPackage(@PathVariable(value = "id") String id) {
        packageService.deletePTPackage(id);
    }

    @GetMapping("/get-list-membership-better/{id}")
    public ResponseEntity<List<Membership>> getBetterMemberships(@PathVariable(value = "id") String id) {
        List<Membership> response = packageService.getListPackageBetter(id);
        return ResponseEntity.ok().body(response);
    }
}
