package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.EquipmentWithCodeRes;
import com.example.gms_backend.dto.response.ErrorRes;
import com.example.gms_backend.dto.response.GetListEquipmentRes;
import com.example.gms_backend.dto.response.GetListRepairRes;
import com.example.gms_backend.entity.Benefit;
import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.EquipmentCategory;
import com.example.gms_backend.entity.EquipmentRepair;
import com.example.gms_backend.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;

    @GetMapping("/get-all-category")
    public ResponseEntity<List<EquipmentCategory>> getAllEquipmentCategory() {
        List<EquipmentCategory> response = equipmentService.getAllEquipmentCategory();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-category")
    public void addEquipmentCategory(@RequestBody EquipmentCategoryReq request) {
        equipmentService.addEquipmentCategory(request);
    }

    @PutMapping("/edit-category/{id}")
    public void editEquipmentCategory(@PathVariable(value = "id") String id, @RequestBody EquipmentCategoryReq request) {
        equipmentService.editEquipmentCategory(id, request);
    }

    @DeleteMapping("/delete-category/{id}")
    public void deleteEquipmentCategory(@PathVariable(value = "id") String id) {
        equipmentService.deleteEquipmentCategory(id);
    }

    @GetMapping("/get-list-equipment")
    public ResponseEntity<GetListEquipmentRes> getListEquipment(@RequestParam String categoryId,
                                                                @RequestParam String gymId,
                                                                @RequestParam String keyword,
                                                                @RequestParam int page,
                                                                @RequestParam int pageSize) {
        GetListEquipmentReq req = new GetListEquipmentReq(categoryId, gymId, keyword, page, pageSize);
        GetListEquipmentRes response = equipmentService.getListEquipment(req);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/export-list-equipment")
    public ResponseEntity<List<Equipment>> exportListEquipment(@RequestParam String categoryId,
                                                               @RequestParam String gymId) {
        List<Equipment> response = equipmentService.exportListEquipment(categoryId, gymId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-equipment")
    public void addEquipment(@RequestBody EquipmentReq request) throws ParseException {
        equipmentService.addEquipment(request);
    }

    @PutMapping("/edit-equipment/{id}")
    public void editEquipment(@PathVariable(value = "id") String id, @RequestBody EquipmentReq request) throws ParseException {
        equipmentService.editEquipment(id, request);
    }

    @DeleteMapping("/delete-equipment/{id}")
    public void deleteEquipment(@PathVariable(value = "id") String id) {
        equipmentService.deleteEquipment(id);
    }

    @GetMapping("/get-list-repair")
    public ResponseEntity<GetListRepairRes> getListEquipmentRepair(@RequestParam String status,
                                                                   @RequestParam String gymId,
                                                                   @RequestParam String keyword,
                                                                   @RequestParam int page,
                                                                   @RequestParam int pageSize) {
        GetListRepairReq req = new GetListRepairReq(status, gymId, keyword, page, pageSize);
        GetListRepairRes response = equipmentService.getListRepairInfo(req);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/export-list-repair")
    public ResponseEntity<List<EquipmentRepair>> exportListEquipmentRepair(@RequestParam String status,
                                                                           @RequestParam String gymId) {
        List<EquipmentRepair> response = equipmentService.exportListRepairInfo(status, gymId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-repair")
    public ResponseEntity<?> addEquipmentRepair(@RequestBody EquipmentRepairReq request) throws ParseException {
        try {
            equipmentService.addEquipmentRepair(request);
            return ResponseEntity.ok().body("Successfully!");
        } catch (Exception e) {
            ErrorRes errorResponse = ErrorRes.builder().error(e.getMessage()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/edit-repair/{id}")
    public void editEquipmentRepair(@PathVariable(value = "id") String id, @RequestBody EquipmentRepairReq request) throws ParseException {
        equipmentService.editEquipmentRepair(id, request);
    }

    @DeleteMapping("/delete-repair/{id}")
    public void deleteEquipmentRepair(@PathVariable(value = "id") String id) {
        equipmentService.deleteEquipmentRepair(id);
    }

    @PutMapping("/handle-repair-status/{id}")
    public void handleRepairStatus(@PathVariable(value = "id") String id, @RequestBody HandleStatusReq request) {
        equipmentService.handleRepairStatus(id, request.getStatus());
    }

    @GetMapping("/get-all-equipment-code/{gymId}")
    public ResponseEntity<List<EquipmentWithCodeRes>> getAllEquipmentWithCode(@PathVariable(value = "gymId") String gymId) {
        List<EquipmentWithCodeRes> response = equipmentService.getAllEquipmentWithCode(gymId);
        return ResponseEntity.ok().body(response);
    }
}
