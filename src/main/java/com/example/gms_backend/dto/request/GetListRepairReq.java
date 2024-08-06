package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRepairReq {
    private String status;
    private String gymId;
    private String keyword;
    private int page;
    private int pageSize;
}
