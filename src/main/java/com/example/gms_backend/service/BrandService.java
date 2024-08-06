package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.BrandInfoReq;
import com.example.gms_backend.dto.response.ImageSliderRes;
import com.example.gms_backend.entity.BrandInfo;

public interface BrandService {
    ImageSliderRes getImageSlider();
    void updateImageSlider(String imageSlider);
    BrandInfo getBrandInfo();
    void updateBrandInfo(BrandInfoReq request);
}
