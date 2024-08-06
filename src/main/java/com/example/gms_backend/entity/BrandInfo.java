package com.example.gms_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brand_infos")
public class BrandInfo {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String nameBrand;
    private String logo;
    private String hotline;
    private String email;
    private String taxCode;
    private String businessAddress;
    private String imageSlider;
    private String bankAccounts;
    private String mediaLink;
    private Double dayPassFee;
    private Date createdAt;
    private Date updatedAt;
}
