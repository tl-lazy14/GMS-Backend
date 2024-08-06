package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NonMemCustomerReq {
    private String name;
    private String phone;
    private String gymId;
}
