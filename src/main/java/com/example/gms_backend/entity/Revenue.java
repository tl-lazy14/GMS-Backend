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
@Table(name = "revenues")
public class Revenue {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private Integer month;
    private Integer year;
    private Double membershipRevenue;
    private Double ptServiceRevenue;
    private Double nonMemRevenue;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private Date createdAt;
    private Date updatedAt;
}
