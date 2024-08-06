package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Equipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentWithCodeRes {
    private String code;
    private Equipment equipment;
}
