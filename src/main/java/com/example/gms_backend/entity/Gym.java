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
@Table(name = "gyms")
public class Gym {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;
    private String address;
    private String description;
    private String phone;
    private String thumbnail;
    private String operatingTime;
    private String listImage;
    private String amenity;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
