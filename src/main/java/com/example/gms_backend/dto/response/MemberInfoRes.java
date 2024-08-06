package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Membership;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberInfoRes {
    private String id;
    private String memberCode;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private Date dob;
    private Membership membership;
    private Date startDate;
    private Date expiredDate;
    private String status;
}
