package com.example.gms_backend.dto.request;

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
public class CoachReq {
    private String name;
    private String email;
    private String phone;
    private String dob;
    private String imageUrl;
    private String level;
    private String experience;
    private String expertise;
    private String certification;
    private String achievements;
    private String description;
    private String gymId;
    private String status;
}
