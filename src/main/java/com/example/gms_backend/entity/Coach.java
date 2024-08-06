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
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String code;
    private String name;
    private String email;
    private String phone;
    private Date dob;
    private String imageUrl;
    private String level;
    private String experience;
    private String expertise;
    private String certification;
    private String achievements;
    private String description;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
