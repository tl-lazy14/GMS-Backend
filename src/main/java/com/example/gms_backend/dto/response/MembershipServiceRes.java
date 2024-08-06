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
public class MembershipServiceRes {
    private String id;
    private Membership membership;
    private Integer isBestPackage;
    private Date startDate;
    private Date expiredDate;
    private Double amount;
    private String status;
}
