package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.CoachReq;
import com.example.gms_backend.dto.request.CoachScheduleReq;
import com.example.gms_backend.dto.response.CoachWithScheduleRes;
import com.example.gms_backend.dto.response.GetListCoachRes;
import com.example.gms_backend.entity.Coach;
import com.example.gms_backend.entity.CoachSchedule;
import com.example.gms_backend.entity.Member;
import com.example.gms_backend.entity.WorkoutResult;

import java.text.ParseException;
import java.util.List;

public interface CoachService {
    GetListCoachRes getListCoach(String level, String status, String gym, String keyword, int page);
    List<Coach> getAllCoachByGym(String gymId);
    List<CoachWithScheduleRes> getListCoachByGymWithSchedule(String gymId);
    List<Coach> getListCoachHomepage();
    void addCoach(CoachReq request) throws ParseException;
    void editCoach(String id, CoachReq request) throws ParseException;
    Coach getCoachInfo(String id);
    List<CoachSchedule> getScheduleOfCoach(String id);
    List<CoachSchedule> getBusyScheduleOfCoach(String id);
    List<Member> getListMemberOfCoach(String id);
    void addSchedule(String coachId, CoachScheduleReq request) throws ParseException;
    CoachSchedule editSchedule(String id, CoachScheduleReq request) throws ParseException;
    void deleteSchedule(String id);
    List<Coach> getOtherCoaches(String id);
}
