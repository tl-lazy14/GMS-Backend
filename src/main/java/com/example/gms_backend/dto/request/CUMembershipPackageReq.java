package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CUMembershipPackageReq {
    private String name;
    private String description;
    private Double priceMonth;
    private String thumbnail;
    private String status;
}
