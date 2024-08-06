package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.BrandInfoReq;
import com.example.gms_backend.dto.response.ImageSliderRes;
import com.example.gms_backend.entity.BrandInfo;
import com.example.gms_backend.repository.BrandInfoRepository;
import com.example.gms_backend.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandInfoRepository brandInfoRepository;

    @Override
    public ImageSliderRes getImageSlider() {
        BrandInfo brandInfo = brandInfoRepository.findFirstByOrderByIdAsc();
        String imageSlider = brandInfo.getImageSlider();
        return ImageSliderRes.builder().imageSlider(imageSlider).build();
    }

    @Override
    public void updateImageSlider(String imageSlider) {
        BrandInfo brandInfo = brandInfoRepository.findFirstByOrderByIdAsc();
        brandInfo.setImageSlider(imageSlider);
        brandInfoRepository.save(brandInfo);
    }

    @Override
    public BrandInfo getBrandInfo() {
        return brandInfoRepository.findFirstByOrderByIdAsc();
    }

    @Override
    public void updateBrandInfo(BrandInfoReq request) {
        BrandInfo brandInfo = brandInfoRepository.findFirstByOrderByIdAsc();
        brandInfo.setNameBrand(request.getNameBrand());
        brandInfo.setLogo(request.getLogo());
        brandInfo.setHotline(request.getHotline());
        brandInfo.setEmail(request.getEmail());
        brandInfo.setTaxCode(request.getTaxCode());
        brandInfo.setBusinessAddress(request.getBusinessAddress());
        brandInfo.setDayPassFee(request.getDayPassFee());
        brandInfo.setBankAccounts(request.getBankAccounts());
        brandInfo.setMediaLink(request.getMediaLink());
        brandInfoRepository.save(brandInfo);
    }
}
