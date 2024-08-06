package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.GymReq;
import com.example.gms_backend.dto.response.GeneralDataDashboardRes;
import com.example.gms_backend.dto.response.GetListCoachDashboardRes;
import com.example.gms_backend.dto.response.GetListMemberRes;
import com.example.gms_backend.entity.Gym;
import com.example.gms_backend.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gym")
@RequiredArgsConstructor
public class GymController {
    private final GymService gymService;

    @GetMapping("/get-list-gym")
    public ResponseEntity<List<Gym>> getListGym() {
        List<Gym> response = gymService.getListGyms();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-list-active-gym")
    public ResponseEntity<List<Gym>> getListActiveGym() {
        List<Gym> response = gymService.getListActiveGyms();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-gym/{id}")
    public ResponseEntity<Gym> getGym(@PathVariable(value = "id") String id) {
        Gym response = gymService.getGym(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-gym")
    public void addGym(@RequestBody GymReq request) {
        gymService.addGym(request);
    }

    @PutMapping("/edit-gym/{id}")
    public void editGym(@PathVariable(value = "id") String id, @RequestBody GymReq request) {
        gymService.editGym(id, request);
    }

    @GetMapping("/dashboard/general-dashboard-data/{gymId}")
    public ResponseEntity<GeneralDataDashboardRes> getGeneralDashboardData(@PathVariable(value = "gymId") String gymId) {
        GeneralDataDashboardRes response = gymService.getGeneralDashboardData(gymId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/dashboard/member-growth-rate/{gymId}/{year}")
    public ResponseEntity<List<Map<String, Object>>> getMonthlyGrowthRate(@PathVariable(value = "gymId") String gymId,
                                                                          @PathVariable(value = "year") int year) {
        List<Map<String, Object>> response = gymService.calculateMonthlyGrowthRate(gymId, year);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/dashboard/get-new-member-today/{gymId}/{page}")
    public ResponseEntity<GetListMemberRes> getNewMembersToday(@PathVariable(value = "gymId") String gymId,
                                                               @PathVariable(value = "page") int page) {
        GetListMemberRes response = gymService.getNewMembersToday(gymId, page);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/dashboard/new-member-by-month/{gymId}/{year}")
    public ResponseEntity<List<Map<String, Object>>> getDataNewMemberByMonth(@PathVariable(value = "gymId") String gymId,
                                                                             @PathVariable(value = "year") int year) {
        List<Map<String, Object>> response = gymService.calculateNewMemberByMonth(gymId, year);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/dashboard/non-mem-customer-by-month/{gymId}/{year}")
    public ResponseEntity<List<Map<String, Object>>> getDataNonMemCustomerByMonth(@PathVariable(value = "gymId") String gymId,
                                                                                  @PathVariable(value = "year") int year) {
        List<Map<String, Object>> response = gymService.calculateNonMemCustomerByMonth(gymId, year);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/dashboard/revenue-by-month/{gymId}/{year}")
    public ResponseEntity<List<Map<String, Object>>> getDataRevenueByMonth(@PathVariable(value = "gymId") String gymId,
                                                                           @PathVariable(value = "year") int year) {
        List<Map<String, Object>> response = gymService.calculateRevenueByMonth(gymId, year);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/dashboard/equipment-repair-cost-by-month/{gymId}/{year}")
    public ResponseEntity<List<Map<String, Object>>> getDataEquipmentRepairCostByMonth(@PathVariable(value = "gymId") String gymId,
                                                                                       @PathVariable(value = "year") int year) {
        List<Map<String, Object>> response = gymService.calculateEquipmentRepairCostByMonth(gymId, year);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/dashboard/get-coaches-ranking/{gymId}/{page}")
    public ResponseEntity<GetListCoachDashboardRes> getCoachesRanking(@PathVariable(value = "gymId") String gymId,
                                                                      @PathVariable(value = "page") int page) {
        GetListCoachDashboardRes response = gymService.getCoachesRanking(gymId, page);
        return ResponseEntity.ok().body(response);
    }
}
