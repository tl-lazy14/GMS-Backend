package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.EquipmentRepair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListRepairRes {
    private List<EquipmentRepair> listItem;
    private int numItem;
}
