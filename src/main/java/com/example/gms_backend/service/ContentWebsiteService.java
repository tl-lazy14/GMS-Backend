package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.EditIntroPageReq;
import com.example.gms_backend.dto.request.GeneralInfoPageReq;
import com.example.gms_backend.entity.ContentWebsite;

import java.util.List;

public interface ContentWebsiteService {
    List<ContentWebsite> getListIntroPage();
    ContentWebsite getIntroPage(String page);

    void editIntroPage(String id, EditIntroPageReq request);

    List<ContentWebsite> getListGeneralInfoPage(String page);

    void addInfoPage(GeneralInfoPageReq request);

    void editInfoPage(String id, GeneralInfoPageReq request);

    void deleteInfoPage(String id);
}
