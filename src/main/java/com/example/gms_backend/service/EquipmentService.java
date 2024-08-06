package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.EquipmentWithCodeRes;
import com.example.gms_backend.dto.response.GetListEquipmentRes;
import com.example.gms_backend.dto.response.GetListRepairRes;
import com.example.gms_backend.entity.Benefit;
import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.EquipmentCategory;
import com.example.gms_backend.entity.EquipmentRepair;

import java.text.ParseException;
import java.util.List;

public interface EquipmentService {
    List<EquipmentCategory> getAllEquipmentCategory();
    void addEquipmentCategory(EquipmentCategoryReq request);
    void editEquipmentCategory(String id, EquipmentCategoryReq request);
    void deleteEquipmentCategory(String id);
    GetListEquipmentRes getListEquipment(GetListEquipmentReq request);
    List<Equipment> exportListEquipment(String categoryId, String gymId);
    void addEquipment(EquipmentReq request) throws ParseException;
    void editEquipment(String id, EquipmentReq request) throws ParseException;
    void deleteEquipment(String id);
    GetListRepairRes getListRepairInfo(GetListRepairReq request);
    List<EquipmentRepair> exportListRepairInfo(String status, String gymId);
    void addEquipmentRepair(EquipmentRepairReq request) throws ParseException;
    void editEquipmentRepair(String id, EquipmentRepairReq request) throws ParseException;
    void deleteEquipmentRepair(String id);
    void handleRepairStatus(String id, String status);
    List<EquipmentWithCodeRes> getAllEquipmentWithCode(String gymId);
}
