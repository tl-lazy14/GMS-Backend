package com.example.gms_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralDataDashboardRes {
    private Integer numMembers;
    private Integer numNonMemCustomers;
    private Integer numEquipment;
    private Integer numCoaches;
    private Double revenue;
    private Double profit;
    private List<DataLabelValueRes> numMembersByMemPackage;
    private List<DataLabelValueRes> numCoachesByLevel;
    private Double totalEquipmentPurchaseCost;
    private Double totalEquipmentRepairCost;
}
