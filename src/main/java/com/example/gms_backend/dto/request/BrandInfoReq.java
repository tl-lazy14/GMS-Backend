package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandInfoReq {
    private String nameBrand;
    private String logo;
    private String hotline;
    private String email;
    private String taxCode;
    private String businessAddress;
    private String bankAccounts;
    private String mediaLink;
    private Double dayPassFee;
}
