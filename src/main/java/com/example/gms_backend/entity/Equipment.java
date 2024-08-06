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
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private EquipmentCategory equipmentCategory;
    private String imageUrl;
    private String manufacturer;
    private Integer totalQuantity;
    private Integer availableQuantity;
    private Integer underMaintenanceQuantity;
    private Date purchaseDate;
    private Date warrantyExpiration;
    private Double unitPrice;
    private Double totalPrice;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private String listCode;
    private Date createdAt;
    private Date updatedAt;
}
