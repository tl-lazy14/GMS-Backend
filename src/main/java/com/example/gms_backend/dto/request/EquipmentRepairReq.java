package com.example.gms_backend.dto.request;

import com.example.gms_backend.entity.Equipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentRepairReq {
    private String code;
    private String equipmentId;
    private String issueDescription;
    private String repairDate;
    private String repairDescription;
    private Double repairCost;
}
