package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.EquipmentWithCodeRes;
import com.example.gms_backend.dto.response.GetListEquipmentRes;
import com.example.gms_backend.dto.response.GetListRepairRes;
import com.example.gms_backend.dto.response.GetListUserRes;
import com.example.gms_backend.entity.*;
import com.example.gms_backend.repository.EquipmentCategoryRepository;
import com.example.gms_backend.repository.EquipmentRepairRepository;
import com.example.gms_backend.repository.EquipmentRepository;
import com.example.gms_backend.repository.GymRepository;
import com.example.gms_backend.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentCategoryRepository equipmentCategoryRepository;
    private final EquipmentRepairRepository equipmentRepairRepository;
    private final EquipmentRepository equipmentRepository;
    private final GymRepository gymRepository;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<EquipmentCategory> getAllEquipmentCategory() {
        return equipmentCategoryRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public void addEquipmentCategory(EquipmentCategoryReq request) {
        EquipmentCategory equipmentCategory = new EquipmentCategory();
        equipmentCategory.setName(request.getName());
        equipmentCategory.setQuantity(0);
        equipmentCategory.setCreatedAt(new Date());
        equipmentCategory.setUpdatedAt(new Date());
        equipmentCategoryRepository.save(equipmentCategory);
    }

    @Override
    public void editEquipmentCategory(String id, EquipmentCategoryReq request) {
        EquipmentCategory equipmentCategory = equipmentCategoryRepository.findById(id).orElseThrow();
        equipmentCategory.setName(request.getName());
        equipmentCategory.setUpdatedAt(new Date());
        equipmentCategoryRepository.save(equipmentCategory);
    }

    @Override
    public void deleteEquipmentCategory(String id) {
        EquipmentCategory equipmentCategory = equipmentCategoryRepository.findById(id).orElseThrow();
        equipmentCategoryRepository.delete(equipmentCategory);
    }

    @Override
    public GetListEquipmentRes getListEquipment(GetListEquipmentReq request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize());
        List<Equipment> listEquipment = equipmentRepository.getListEquipment(request.getCategoryId(), request.getGymId(), request.getKeyword(), pageable);
        int numEquipment = equipmentRepository.countListEquipment(request.getCategoryId(), request.getGymId(), request.getKeyword());
        return GetListEquipmentRes.builder()
                .listEquipment(listEquipment)
                .numEquipment(numEquipment)
                .build();
    }

    @Override
    public List<Equipment> exportListEquipment(String categoryId, String gymId) {
        return equipmentRepository.exportListEquipment(categoryId, gymId);
    }

    @Override
    public void addEquipment(EquipmentReq request) throws ParseException {
        Equipment equipment = new Equipment();
        equipment.setName(request.getName());

        EquipmentCategory category = equipmentCategoryRepository.findById(request.getCategoryId()).orElseThrow();
        int currentQuantityOfCategory = category.getQuantity();
        category.setQuantity(currentQuantityOfCategory + request.getTotalQuantity());
        equipmentCategoryRepository.save(category);
        equipment.setEquipmentCategory(category);

        equipment.setImageUrl(request.getImageUrl());
        equipment.setManufacturer(request.getManufacturer());
        equipment.setTotalQuantity(request.getTotalQuantity());
        equipment.setAvailableQuantity(request.getTotalQuantity());
        equipment.setUnderMaintenanceQuantity(0);
        equipment.setPurchaseDate(dateFormat.parse(request.getPurchaseDate()));
        equipment.setWarrantyExpiration(dateFormat.parse(request.getWarrantyExpiration()));
        equipment.setUnitPrice(request.getUnitPrice());
        equipment.setTotalPrice(request.getTotalPrice());
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        equipment.setGym(gym);
        // Tạo listcode
        int totalQuantity = request.getTotalQuantity();
        String listCode = generateListCode(totalQuantity);
        equipment.setListCode(listCode);
        equipment.setCreatedAt(new Date());
        equipment.setUpdatedAt(new Date());
        equipmentRepository.save(equipment);
    }

    @Override
    public void editEquipment(String id, EquipmentReq request) throws ParseException {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow();
        equipment.setName(request.getName());
        equipment.setImageUrl(request.getImageUrl());
        equipment.setManufacturer(request.getManufacturer());
        equipment.setPurchaseDate(dateFormat.parse(request.getPurchaseDate()));
        equipment.setWarrantyExpiration(dateFormat.parse(request.getWarrantyExpiration()));
        equipment.setUnitPrice(request.getUnitPrice());
        equipment.setTotalPrice(request.getTotalPrice());

        EquipmentCategory prevCategory = equipment.getEquipmentCategory();
        EquipmentCategory newCategory = equipmentCategoryRepository.findById(request.getCategoryId()).orElseThrow();
        if (!Objects.equals(prevCategory.getId(), newCategory.getId())) {
            int currentQuantityOfPrevCategory = prevCategory.getQuantity();
            int currentQuantityOfNewCategory = newCategory.getQuantity();
            prevCategory.setQuantity(currentQuantityOfPrevCategory - equipment.getTotalQuantity());
            newCategory.setQuantity(currentQuantityOfNewCategory + equipment.getTotalQuantity());
            equipmentCategoryRepository.save(prevCategory);
            equipmentCategoryRepository.save(newCategory);
        }
        equipment.setEquipmentCategory(newCategory);
        equipment.setUpdatedAt(new Date());
        equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(String id) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow();
        EquipmentCategory category = equipmentCategoryRepository.findById(equipment.getEquipmentCategory().getId()).orElseThrow();
        int currentQuantityOfCategory = category.getQuantity();
        category.setQuantity(currentQuantityOfCategory - equipment.getTotalQuantity());
        equipmentCategoryRepository.save(category);
        equipmentRepository.delete(equipment);
    }

    private String generateListCode(int totalQuantity) {
        Random random = new Random();
        StringBuilder listCodeBuilder = new StringBuilder();

        for (int i = 0; i < totalQuantity; i++) {
            StringBuilder codeBuilder = new StringBuilder();

            // Generate 4 uppercase letters
            for (int j = 0; j < 4; j++) {
                char letter = (char) ('A' + random.nextInt(26));
                codeBuilder.append(letter);
            }

            // Generate 4 digits
            for (int j = 0; j < 4; j++) {
                char digit = (char) ('0' + random.nextInt(10));
                codeBuilder.append(digit);
            }

            // Append code to listCodeBuilder
            if (i > 0) {
                listCodeBuilder.append('-');
            }
            listCodeBuilder.append(codeBuilder.toString());
        }

        return listCodeBuilder.toString();
    }

    @Override
    public GetListRepairRes getListRepairInfo(GetListRepairReq request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize());
        List<EquipmentRepair> list= equipmentRepairRepository.getListEquipmentRepair(request.getStatus(), request.getGymId(), request.getKeyword(), pageable);
        int num = equipmentRepairRepository.countListEquipmentRepair(request.getStatus(), request.getGymId(), request.getKeyword());
        return GetListRepairRes.builder()
                .listItem(list)
                .numItem(num)
                .build();
    }

    @Override
    public List<EquipmentRepair> exportListRepairInfo(String status, String gymId) {
        return equipmentRepairRepository.exportListEquipmentRepair(status, gymId);
    }

    @Override
    public void addEquipmentRepair(EquipmentRepairReq request) throws ParseException {
        List<EquipmentRepair> checkEquipmentNotRepair = equipmentRepairRepository.findExistEquipmentNotRepair(request.getCode());
        if (!checkEquipmentNotRepair.isEmpty()) {
            throw new RuntimeException("This equipment is already broken and has not yet been repaired!");
        };

        EquipmentRepair equipmentRepair = new EquipmentRepair();
        equipmentRepair.setCode(request.getCode());

        Equipment equipment = equipmentRepository.findById(request.getEquipmentId()).orElseThrow();
        int currentNumAvail = equipment.getAvailableQuantity();
        int currentNumUnAvail = equipment.getUnderMaintenanceQuantity();
        equipment.setAvailableQuantity(currentNumAvail - 1);
        equipment.setUnderMaintenanceQuantity(currentNumUnAvail + 1);
        equipmentRepository.save(equipment);
        equipmentRepair.setEquipment(equipment);

        if (!Objects.equals(request.getIssueDescription(), "")) {
            equipmentRepair.setIssueDescription(request.getIssueDescription());
        }
        if (!Objects.equals(request.getRepairDate(), "not-select")) {
            equipmentRepair.setRepairDate(dateFormat.parse(request.getRepairDate()));
        }
        if (!Objects.equals(request.getRepairDescription(), "")) {
            equipmentRepair.setRepairDescription(request.getRepairDescription());
        }
        if (request.getRepairCost() != 0) {
            equipmentRepair.setRepairCost(request.getRepairCost());
        }
        equipmentRepair.setStatus("Pending");
        equipmentRepair.setCreatedAt(new Date());
        equipmentRepair.setUpdatedAt(new Date());
        equipmentRepairRepository.save(equipmentRepair);
    }

    @Override
    public void editEquipmentRepair(String id, EquipmentRepairReq request) throws ParseException {
        EquipmentRepair equipmentRepair = equipmentRepairRepository.findById(id).orElseThrow();
        equipmentRepair.setIssueDescription(request.getIssueDescription());
        if (Objects.equals(request.getRepairDate(), "not-select")) {
            equipmentRepair.setRepairDate(null);
        } else {
            equipmentRepair.setRepairDate(dateFormat.parse(request.getRepairDate()));
        }
        equipmentRepair.setRepairDescription(request.getRepairDescription());
        if (request.getRepairCost() == 0) {
            equipmentRepair.setRepairCost(null);
        } else {
            equipmentRepair.setRepairCost(request.getRepairCost());
        }
        equipmentRepair.setUpdatedAt(new Date());
        equipmentRepairRepository.save(equipmentRepair);
    }

    @Override
    public void deleteEquipmentRepair(String id) {
        EquipmentRepair equipmentRepair = equipmentRepairRepository.findById(id).orElseThrow();
        if (!Objects.equals(equipmentRepair.getStatus(), "Completed")) {
            Equipment equipment = equipmentRepair.getEquipment();
            int currentNumAvail = equipment.getAvailableQuantity();
            int currentNumUnAvail = equipment.getUnderMaintenanceQuantity();
            equipment.setAvailableQuantity(currentNumAvail + 1);
            equipment.setUnderMaintenanceQuantity(currentNumUnAvail - 1);
            equipmentRepository.save(equipment);
        }
        equipmentRepairRepository.delete(equipmentRepair);
    }

    @Override
    public void handleRepairStatus(String id, String status) {
        EquipmentRepair equipmentRepair = equipmentRepairRepository.findById(id).orElseThrow();
        Equipment equipment = equipmentRepair.getEquipment();
        int currentNumAvail = equipment.getAvailableQuantity();
        int currentNumUnAvail = equipment.getUnderMaintenanceQuantity();
        String currentStatus = equipmentRepair.getStatus();
        if (Objects.equals(currentStatus, "Completed") && !Objects.equals(status, "Completed")) {
            equipment.setAvailableQuantity(currentNumAvail - 1);
            equipment.setUnderMaintenanceQuantity(currentNumUnAvail + 1);
        } else if (!Objects.equals(currentStatus, "Completed") && Objects.equals(status, "Completed")) {
            equipment.setAvailableQuantity(currentNumAvail + 1);
            equipment.setUnderMaintenanceQuantity(currentNumUnAvail - 1);
        }
        equipmentRepository.save(equipment);
        equipmentRepair.setStatus(status);
        equipmentRepairRepository.save(equipmentRepair);
    }

    @Override
    public List<EquipmentWithCodeRes> getAllEquipmentWithCode(String gymId) {
        List<EquipmentWithCodeRes> response = new ArrayList<>();
        Gym gym = gymRepository.findById(gymId).orElseThrow();
        List<Equipment> equipmentList = equipmentRepository.findByGym(gym);
        for (Equipment equipment : equipmentList) {
            List<String> listCode = splitString(equipment.getListCode());
            for (String code : listCode) {
                EquipmentWithCodeRes res = new EquipmentWithCodeRes();
                res.setCode(code);
                res.setEquipment(equipment);
                response.add(res);
            }
        }
        return response;
    }

    public static List<String> splitString(String input) {
        String[] parts = input.split("-");
        return Arrays.asList(parts);
    }
}
