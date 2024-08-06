package com.example.gms_backend.dto.request;

import com.example.gms_backend.dto.response.CheckBenefitIncludeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemPackageListBenefitDTO {
    private String id;
    private List<CheckBenefitIncludeDTO> benefits;
}
