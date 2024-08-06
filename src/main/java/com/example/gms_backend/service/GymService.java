package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.GymReq;
import com.example.gms_backend.dto.response.GeneralDataDashboardRes;
import com.example.gms_backend.dto.response.GetListCoachDashboardRes;
import com.example.gms_backend.dto.response.GetListMemberRes;
import com.example.gms_backend.entity.Gym;

import java.util.List;
import java.util.Map;

public interface GymService {
    List<Gym> getListGyms();
    List<Gym> getListActiveGyms();
    Gym getGym(String id);
    void addGym(GymReq request);
    void editGym(String id, GymReq request);
    GeneralDataDashboardRes getGeneralDashboardData(String gymId);
    List<Map<String, Object>> calculateMonthlyGrowthRate(String gymId, int year);
    GetListMemberRes getNewMembersToday(String gymId, int page);
    List<Map<String, Object>> calculateNewMemberByMonth(String gymId, int year);
    List<Map<String, Object>> calculateNonMemCustomerByMonth(String gymId, int year);
    List<Map<String, Object>> calculateRevenueByMonth(String gymId, int year);
    List<Map<String, Object>> calculateEquipmentRepairCostByMonth(String gymId, int year);
    GetListCoachDashboardRes getCoachesRanking(String gymId, int page);
}
