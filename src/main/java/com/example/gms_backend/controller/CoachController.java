package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.ArticleReq;
import com.example.gms_backend.dto.request.CoachReq;
import com.example.gms_backend.dto.request.CoachScheduleReq;
import com.example.gms_backend.dto.request.GetListArticleReq;
import com.example.gms_backend.dto.response.CoachWithScheduleRes;
import com.example.gms_backend.dto.response.GetListArticleRes;
import com.example.gms_backend.dto.response.GetListCoachRes;
import com.example.gms_backend.entity.*;
import com.example.gms_backend.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/coach")
@RequiredArgsConstructor
public class CoachController {
    private final CoachService coachService;

    @GetMapping("/get-list-coach")
    public ResponseEntity<GetListCoachRes> getListCoach(@RequestParam String level,
                                                        @RequestParam String status,
                                                        @RequestParam String gym,
                                                        @RequestParam String keyword,
                                                        @RequestParam int page) {
        GetListCoachRes response = coachService.getListCoach(level, status, gym, keyword, page);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-all-coach/{gymId}")
    public ResponseEntity<List<Coach>> getAllCoach(@PathVariable(value = "gymId") String gymId) {
        List<Coach> response = coachService.getAllCoachByGym(gymId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-list-coach-with-schedule/{gymId}")
    public ResponseEntity<List<CoachWithScheduleRes>> getListCoachWithSchedule(@PathVariable(value = "gymId") String gymId) {
        List<CoachWithScheduleRes> response = coachService.getListCoachByGymWithSchedule(gymId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-list-coach-homepage")
    public ResponseEntity<List<Coach>> getListCoachHomepage() {
        List<Coach> response = coachService.getListCoachHomepage();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-coach-info/{id}")
    public ResponseEntity<Coach> getCoachInfo(@PathVariable(value = "id") String id) {
        Coach coach = coachService.getCoachInfo(id);
        return ResponseEntity.ok().body(coach);
    }

    @PostMapping("/add-coach")
    public void addCoach(@RequestBody CoachReq request) throws ParseException {
        coachService.addCoach(request);
    }

    @PutMapping("/edit-coach/{id}")
    public void editCoach(@PathVariable(value = "id") String id,
                          @RequestBody CoachReq request) throws ParseException {
        coachService.editCoach(id, request);
    }

    @GetMapping("/get-coach-schedule/{id}")
    public ResponseEntity<List<CoachSchedule>> getScheduleOfCoach(@PathVariable(value = "id") String id) {
        List<CoachSchedule> response = coachService.getScheduleOfCoach(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-coach-busy-schedule/{id}")
    public ResponseEntity<List<CoachSchedule>> getBusyScheduleOfCoach(@PathVariable(value = "id") String id) {
        List<CoachSchedule> response = coachService.getBusyScheduleOfCoach(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-list-member/{id}")
    public ResponseEntity<List<Member>> getListMemberOfCoach(@PathVariable(value = "id") String id) {
        List<Member> response = coachService.getListMemberOfCoach(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-schedule/{coachId}")
    public void addCoachSchedule(@PathVariable(value = "coachId") String coachId,
                                 @RequestBody CoachScheduleReq request) throws ParseException {
        coachService.addSchedule(coachId, request);
    }

    @PutMapping("/edit-schedule/{id}")
    public ResponseEntity<CoachSchedule> editCoachSchedule(@PathVariable(value = "id") String id,
                                  @RequestBody CoachScheduleReq request) throws ParseException {
        CoachSchedule response = coachService.editSchedule(id, request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete-schedule/{id}")
    public void deleteCoachSchedule(@PathVariable(value = "id") String id) {
        coachService.deleteSchedule(id);
    }

    @GetMapping("/get-other-coaches/{id}")
    public ResponseEntity<List<Coach>> getOtherCoaches(@PathVariable(value = "id") String id) {
        List<Coach> response = coachService.getOtherCoaches(id);
        return ResponseEntity.ok().body(response);
    }
}
