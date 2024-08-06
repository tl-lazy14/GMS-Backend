package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.EditIntroPageReq;
import com.example.gms_backend.dto.request.GeneralInfoPageReq;
import com.example.gms_backend.entity.ContentWebsite;
import com.example.gms_backend.service.ContentWebsiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content-website")
@RequiredArgsConstructor
public class ContentWebsiteController {
    private final ContentWebsiteService contentWebsiteService;

    @GetMapping("/get-list-intro-page")
    public ResponseEntity<List<ContentWebsite>> getListIntroPage() {
        List<ContentWebsite> response = contentWebsiteService.getListIntroPage();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-intro-page")
    public ResponseEntity<ContentWebsite> getIntroPage(@RequestParam String page) {
        ContentWebsite response = contentWebsiteService.getIntroPage(page);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/edit-intro-page/{id}")
    public void editIntroPage(@PathVariable(value = "id") String id, @RequestBody EditIntroPageReq request) {
        contentWebsiteService.editIntroPage(id, request);
    }

    @GetMapping("/get-list-general-info")
    public ResponseEntity<List<ContentWebsite>> getListGeneralInfo(@RequestParam String page) {
        List<ContentWebsite> response = contentWebsiteService.getListGeneralInfoPage(page);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-general-info")
    public void addGeneralInfo(@RequestBody GeneralInfoPageReq request) {
        contentWebsiteService.addInfoPage(request);
    }

    @PutMapping("/edit-general-info/{id}")
    public void editGeneralInfo(@PathVariable(value = "id") String id, @RequestBody GeneralInfoPageReq request) {
        contentWebsiteService.editInfoPage(id, request);
    }

    @DeleteMapping("/delete-general-info/{id}")
    public void deleteGeneralInfo(@PathVariable(value = "id") String id) {
        contentWebsiteService.deleteInfoPage(id);
    }
}
