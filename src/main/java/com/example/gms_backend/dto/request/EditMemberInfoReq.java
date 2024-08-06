package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditMemberInfoReq {
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String dob;
}
