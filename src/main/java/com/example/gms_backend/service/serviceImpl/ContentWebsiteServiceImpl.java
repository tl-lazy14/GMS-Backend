package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.EditIntroPageReq;
import com.example.gms_backend.dto.request.GeneralInfoPageReq;
import com.example.gms_backend.entity.ContentWebsite;
import com.example.gms_backend.repository.ContentWebsiteRepository;
import com.example.gms_backend.service.ContentWebsiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentWebsiteServiceImpl implements ContentWebsiteService {
    private final ContentWebsiteRepository contentWebsiteRepository;

    @Override
    public List<ContentWebsite> getListIntroPage() {
        return contentWebsiteRepository.findAllByTypeOrderByCreatedAtAsc("intro-page");
    }

    @Override
    public ContentWebsite getIntroPage(String page) {
        return contentWebsiteRepository.findByTypeAndTitle("intro-page", page);
    }

    @Override
    public void editIntroPage(String id, EditIntroPageReq request) {
        ContentWebsite introPage = contentWebsiteRepository.findById(id).orElseThrow();
        introPage.setDescription(request.getDescription());
        introPage.setImage(request.getImage());
        contentWebsiteRepository.save(introPage);
    }

    @Override
    public List<ContentWebsite> getListGeneralInfoPage(String page) {
        return contentWebsiteRepository.findAllByTypeAndPageOrderByCreatedAtDesc("general-info", page);
    }

    @Override
    public void addInfoPage(GeneralInfoPageReq request) {
        ContentWebsite generalInfo = new ContentWebsite();
        generalInfo.setTitle(request.getTitle());
        generalInfo.setDescription(request.getDescription());
        generalInfo.setImage(request.getImage());
        generalInfo.setType("general-info");
        generalInfo.setPage(request.getPage());
        generalInfo.setCreatedAt(new Date());
        generalInfo.setUpdatedAt(new Date());
        contentWebsiteRepository.save(generalInfo);
    }

    @Override
    public void editInfoPage(String id, GeneralInfoPageReq request) {
        ContentWebsite generalInfo = contentWebsiteRepository.findById(id).orElseThrow();
        generalInfo.setTitle(request.getTitle());
        generalInfo.setDescription(request.getDescription());
        generalInfo.setImage(request.getImage());
        contentWebsiteRepository.save(generalInfo);
    }

    @Override
    public void deleteInfoPage(String id) {
        ContentWebsite info = contentWebsiteRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found!"));
        contentWebsiteRepository.delete(info);
    }
}
