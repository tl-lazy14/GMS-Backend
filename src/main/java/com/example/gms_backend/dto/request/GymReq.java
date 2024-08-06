package com.example.gms_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymReq {
    private String name;
    private String address;
    private String description;
    private String phone;
    private String thumbnail;
    private String operatingTime;
    private String listImage;
    private String amenity;
    private String status;
}
