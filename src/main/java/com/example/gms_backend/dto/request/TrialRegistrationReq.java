package com.example.gms_backend.dto.request;

import com.example.gms_backend.entity.Gym;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialRegistrationReq {
    private String name;
    private String phone;
    private String gymId;
    private String timeContact;
}
