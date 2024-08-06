package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Equipment;
import com.example.gms_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListEquipmentRes {
    private List<Equipment> listEquipment;
    private int numEquipment;
}
