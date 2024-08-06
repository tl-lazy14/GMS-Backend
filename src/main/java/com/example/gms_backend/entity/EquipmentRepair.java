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
@Table(name = "equipment_repairs")
public class EquipmentRepair {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    private String issueDescription;
    private Date repairDate;
    private String repairDescription;
    private Double repairCost;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
