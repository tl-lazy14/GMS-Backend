package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.*;
import com.example.gms_backend.entity.*;

import java.text.ParseException;
import java.util.List;

public interface CustomerService {
    GetListNonMemCustomerRes getListNonMemCustomer(String gymId, String date, String keyword, int page, int pageSize) throws ParseException;
    List<NonMemberCustomer> exportListNonMemCustomer(String gymId, String date) throws ParseException;
    void addNonMemCustomer(NonMemCustomerReq request);
    void editNonMemCustomer(String id, NonMemCustomerReq request);
    void deleteNonMemCustomer(String id);
    GetListTransferRegistrationRes getListTransferRegistration(String membershipId, String status, String gymId, String keyword, int page, int pageSize);
    void createTransferRegistration(AddMemberReq request) throws ParseException;
    void handleApprove(String id, String status);
    GetListTrialRegistrationRes getListTrialRegistration(String contactStatus, String approvalStatus, String gymId, String keyword, int page, int pageSize);
    List<TrialRegistration> exportListTrialRegistration(String contactStatus, String approvalStatus, String gymId);
    void selectTrialDate(String id, String date) throws ParseException;
    void handleTrialContactStatus(String id, String status);
    void handleTrialApprovalStatus(String id, String status);
    GetListMemberRes getListMember(String membershipId, String status, String gymId, String keyword, int page, int pageSize);
    List<MemberInfoRes> exportListMember(String membershipId, String status, String gymId);
    void addMember(AddMemberReq request) throws ParseException;
    void editMemberInfo(String id, EditMemberInfoReq request) throws ParseException;
    Member getMemberInfo(String id);
    List<MembershipServiceRes> getMembershipServiceInfo(String id);
    List<PTServiceRes> getPTServiceInfo(String id);
    List<MemberScheduleRes> getMemberSchedule(String id);
    void extendMembershipService(String id, ExtendMembershipReq request) throws ParseException;
    void upgradeMembershipService(String id, UpgradeMembershipReq request);
    void registerPTService(String id, RegisterPTServiceReq request) throws ParseException;
    void selectPT(String id, SelectPTReq request);
    void addWorkoutResult(String id, WorkoutResultReq request) ;
    void editWorkoutResult(String id, WorkoutResultReq request);
    GetListResultRes getListResults(String gymId, String gender, int age, int minNumWeeks, int maxNumWeeks, String keyword, int page);
    WorkoutResult getWorkoutResult(String id);
    List<WorkoutResult> getWorkoutResultHomePage();
    void registerTrial(TrialRegistrationReq request);
    List<WorkoutResult> getOtherResult(String id);
    GetPayUrlRes generateVNPayUrl(Long money);
}
