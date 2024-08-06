package com.example.gms_backend.dto.request;

import com.example.gms_backend.entity.EquipmentCategory;
import com.example.gms_backend.entity.Gym;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentReq {
    private String name;
    private String categoryId;
    private String imageUrl;
    private String manufacturer;
    private Integer totalQuantity;
    private String purchaseDate;
    private String warrantyExpiration;
    private Double unitPrice;
    private Double totalPrice;
    private String gymId;
}
