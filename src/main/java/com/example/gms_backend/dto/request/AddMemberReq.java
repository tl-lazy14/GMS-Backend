package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberReq {
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String dob;
    private String gymId;
    private String membershipId;
    private String startDate;
    private String endDate;
    private Double amount;
}
