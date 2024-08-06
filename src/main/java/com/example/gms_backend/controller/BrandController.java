package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.BrandInfoReq;
import com.example.gms_backend.dto.request.UpdateImageSliderReq;
import com.example.gms_backend.dto.response.ImageSliderRes;
import com.example.gms_backend.entity.BrandInfo;
import com.example.gms_backend.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("/get-image-slider")
    public ResponseEntity<ImageSliderRes> getImageSlider() {
        ImageSliderRes response = brandService.getImageSlider();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update-image-slider")
    public void updateImageSlider(@RequestBody UpdateImageSliderReq request) {
        brandService.updateImageSlider(request.getImageSlider());
    }

    @GetMapping("/get-brand-info")
    public ResponseEntity<BrandInfo> getBrandInfo() {
        BrandInfo response = brandService.getBrandInfo();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update-brand-info")
    public void updateBrandInfo(@RequestBody BrandInfoReq request) {
        brandService.updateBrandInfo(request);
    }
}
