package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditUserReq {
    private String name;
    private String phone;
    private String dob;
    private String address;
    private String gymId;
}
