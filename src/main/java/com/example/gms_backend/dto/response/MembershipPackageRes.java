package com.example.gms_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembershipPackageRes {
    private String id;
    private String name;
    private String description;
    private Double priceMonth;
    private String thumbnail;
    private String status;
    private Long totalMembers;
    private List<CheckBenefitIncludeDTO> benefits;
}
