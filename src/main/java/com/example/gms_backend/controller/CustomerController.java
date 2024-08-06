package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.*;
import com.example.gms_backend.entity.*;
import com.example.gms_backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/get-list-non-mem-cus")
    public ResponseEntity<GetListNonMemCustomerRes> getListNonMemCustomer(@RequestParam String gymId,
                                                                          @RequestParam String date,
                                                                          @RequestParam String keyword,
                                                                          @RequestParam int page,
                                                                          @RequestParam int pageSize) throws ParseException {
        GetListNonMemCustomerRes response = customerService.getListNonMemCustomer(gymId, date, keyword, page, pageSize);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/export-list-non-mem-cus")
    public ResponseEntity<List<NonMemberCustomer>> exportListNonMemCustomer(@RequestParam String gymId,
                                                                            @RequestParam String date) throws ParseException {
        List<NonMemberCustomer> response = customerService.exportListNonMemCustomer(gymId, date);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-non-mem-cus")
    public void addNonMemCustomer(@RequestBody NonMemCustomerReq request) {
        customerService.addNonMemCustomer(request);
    }

    @PutMapping("/edit-non-mem-cus/{id}")
    public void editNonMemCustomer(@PathVariable(value = "id") String id, @RequestBody NonMemCustomerReq request) throws ParseException {
        customerService.editNonMemCustomer(id, request);
    }

    @DeleteMapping("/delete-non-mem-cus/{id}")
    public void deleteNonMemCustomer(@PathVariable(value = "id") String id) {
        customerService.deleteNonMemCustomer(id);
    }

    @GetMapping("/get-list-transfer-registration")
    public ResponseEntity<GetListTransferRegistrationRes> getListTransferRegistration(@RequestParam String membershipId,
                                                                                      @RequestParam String status,
                                                                                      @RequestParam String gymId,
                                                                                      @RequestParam String keyword,
                                                                                      @RequestParam int page,
                                                                                      @RequestParam int pageSize) {
        GetListTransferRegistrationRes response = customerService.getListTransferRegistration(membershipId, status, gymId, keyword, page, pageSize);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/create-transfer-registration")
    public void createTransferRegistration(@RequestBody AddMemberReq request) throws ParseException {
        customerService.createTransferRegistration(request);
    }

    @PutMapping("/handle-approve-member-registration/{id}")
    public void handleApproveTransferRegistration(@PathVariable(value = "id") String id, @RequestBody HandleStatusReq request) {
        customerService.handleApprove(id, request.getStatus());
    }

    @GetMapping("/get-list-trial-registration")
    public ResponseEntity<GetListTrialRegistrationRes> getListTrialRegistration(@RequestParam String contactStatus,
                                                                                @RequestParam String approvalStatus,
                                                                                @RequestParam String gymId,
                                                                                @RequestParam String keyword,
                                                                                @RequestParam int page,
                                                                                @RequestParam int pageSize) {
        GetListTrialRegistrationRes response = customerService.getListTrialRegistration(contactStatus, approvalStatus, gymId, keyword, page, pageSize);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/export-list-trial-registration")
    public ResponseEntity<List<TrialRegistration>> exportListTrialRegistration(@RequestParam String contactStatus,
                                                                               @RequestParam String approvalStatus,
                                                                               @RequestParam String gymId) {
        List<TrialRegistration> response = customerService.exportListTrialRegistration(contactStatus, approvalStatus, gymId);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/handle-contact-trial/{id}")
    public void handleTrialContactStatus(@PathVariable(value = "id") String id, @RequestBody HandleStatusReq request) {
        customerService.handleTrialContactStatus(id, request.getStatus());
    }

    @PutMapping("/handle-approve-trial/{id}")
    public void handleTrialApprovalStatus(@PathVariable(value = "id") String id, @RequestBody HandleStatusReq request) {
        customerService.handleTrialApprovalStatus(id, request.getStatus());
    }

    @PutMapping("/select-trial-date/{id}")
    public void selectTrialDate(@PathVariable(value = "id") String id, @RequestBody DateReq request) throws ParseException {
        customerService.selectTrialDate(id, request.getDate());
    }

    @GetMapping("/get-list-member")
    public ResponseEntity<GetListMemberRes> getListMember(@RequestParam String membershipId,
                                                          @RequestParam String status,
                                                          @RequestParam String gymId,
                                                          @RequestParam String keyword,
                                                          @RequestParam int page,
                                                          @RequestParam int pageSize) {
        GetListMemberRes response = customerService.getListMember(membershipId, status, gymId, keyword, page, pageSize);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/export-list-member")
    public ResponseEntity<List<MemberInfoRes>> exportListMember(@RequestParam String membershipId,
                                                                @RequestParam String status,
                                                                @RequestParam String gymId) {
        List<MemberInfoRes> response = customerService.exportListMember(membershipId, status, gymId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-member")
    public void addMember(@RequestBody AddMemberReq request) throws ParseException {
        customerService.addMember(request);
    }

    @PutMapping("/edit-member/{id}")
    public void editMember(@PathVariable(value = "id") String id,
                           @RequestBody EditMemberInfoReq request) throws ParseException {
        customerService.editMemberInfo(id, request);
    }

    @GetMapping("/get-member-info/{id}")
    public ResponseEntity<Member> getMemberInfo(@PathVariable(value = "id") String id) {
        Member response = customerService.getMemberInfo(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-membership-service-info/{id}")
    public ResponseEntity<List<MembershipServiceRes>> getMembershipServiceInfo(@PathVariable(value = "id") String id) {
        List<MembershipServiceRes> response = customerService.getMembershipServiceInfo(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-pt-service-info/{id}")
    public ResponseEntity<List<PTServiceRes>> getPTServiceInfo(@PathVariable(value = "id") String id) {
        List<PTServiceRes> response = customerService.getPTServiceInfo(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-member-schedule/{id}")
    public ResponseEntity<List<MemberScheduleRes>> getMemberSchedule(@PathVariable(value = "id") String id) {
        List<MemberScheduleRes> response = customerService.getMemberSchedule(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/extend-service/{id}")
    public void extendService(@PathVariable(value = "id") String id,
                              @RequestBody ExtendMembershipReq request) throws ParseException {
        customerService.extendMembershipService(id, request);
    }

    @PutMapping("/upgrade-service/{id}")
    public void upgradeService(@PathVariable(value = "id") String id,
                               @RequestBody UpgradeMembershipReq request) throws ParseException {
        customerService.upgradeMembershipService(id, request);
    }

    @PostMapping("/register-pt-service/{id}")
    public void registerPTService(@PathVariable(value = "id") String id,
                                  @RequestBody RegisterPTServiceReq request) throws ParseException {
        customerService.registerPTService(id, request);
    }

    @PutMapping("/select-pt/{id}")
    public void selectPT(@PathVariable(value = "id") String id,
                         @RequestBody SelectPTReq request) {
        customerService.selectPT(id, request);
    }

    @PostMapping("/add-workout-result/{id}")
    public void addResult(@PathVariable(value = "id") String id,
                          @RequestBody WorkoutResultReq request) {
        customerService.addWorkoutResult(id, request);
    }

    @PutMapping("/edit-workout-result/{id}")
    public void editResult(@PathVariable(value = "id") String id,
                           @RequestBody WorkoutResultReq request) {
        customerService.editWorkoutResult(id, request);
    }

    @GetMapping("/get-list-result")
    public ResponseEntity<GetListResultRes> getListTrainingResult(@RequestParam String gymId,
                                                                  @RequestParam String gender,
                                                                  @RequestParam int age,
                                                                  @RequestParam int minNumWeeks,
                                                                  @RequestParam int maxNumWeeks,
                                                                  @RequestParam String keyword,
                                                                  @RequestParam int page) {
        GetListResultRes response = customerService.getListResults(gymId, gender, age, minNumWeeks, maxNumWeeks, keyword, page);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-training-result/{id}")
    public ResponseEntity<WorkoutResult> getTrainingResult(@PathVariable(value = "id") String id) {
        WorkoutResult response = customerService.getWorkoutResult(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-workout-result-homepage")
    public ResponseEntity<List<WorkoutResult>> getWorkoutResultHomepage() {
        List<WorkoutResult> response = customerService.getWorkoutResultHomePage();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/register-free-trial")
    public void registerTrial(@RequestBody TrialRegistrationReq request) {
        customerService.registerTrial(request);
    }

    @GetMapping("/get-other-result/{id}")
    public ResponseEntity<List<WorkoutResult>> getOtherResult(@PathVariable(value = "id") String id) {
        List<WorkoutResult> response = customerService.getOtherResult(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-pay-url")
    public ResponseEntity<GetPayUrlRes> generatePayUrl(@RequestParam Long amount) {
        GetPayUrlRes response = customerService.generateVNPayUrl(amount);
        return ResponseEntity.ok().body(response);
    }
}
