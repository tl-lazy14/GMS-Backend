package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserReq {
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String dob;
    private String address;
    private String gymId;
}
