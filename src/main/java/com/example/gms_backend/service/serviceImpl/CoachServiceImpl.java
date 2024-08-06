package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.CoachReq;
import com.example.gms_backend.dto.request.CoachScheduleReq;
import com.example.gms_backend.dto.response.CoachWithScheduleRes;
import com.example.gms_backend.dto.response.GetListCoachRes;
import com.example.gms_backend.entity.*;
import com.example.gms_backend.repository.*;
import com.example.gms_backend.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;
    private final CoachScheduleRepository coachScheduleRepository;
    private final GymRepository gymRepository;
    private final MemberServiceRepository memberServiceRepository;
    private final MemberRepository memberRepository;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public GetListCoachRes getListCoach(String level, String status, String gym, String keyword, int page) {
        Pageable pageable = PageRequest.of(page - 1, 9);
        List<Coach> listCoach = coachRepository.getListCoach(level, status, gym, keyword, pageable);
        int numCoach = coachRepository.countListCoach(level, status, gym, keyword);
        return GetListCoachRes.builder()
                .listItem(listCoach)
                .numItem(numCoach)
                .build();
    }

    @Override
    public List<Coach> getAllCoachByGym(String gymId) {
        Gym gym = gymRepository.findById(gymId).orElseThrow();
        return coachRepository.findByGymAndStatusOrderByCreatedAtDesc(gym, "Active");
    }

    @Override
    public List<CoachWithScheduleRes> getListCoachByGymWithSchedule(String gymId) {
        List<CoachWithScheduleRes> response = new ArrayList<>();

        Gym gym = gymRepository.findById(gymId).orElseThrow();
        List<Coach> coachList = coachRepository.findByGymAndStatusOrderByCreatedAtDesc(gym, "Active");

        for (Coach coach : coachList) {
            CoachWithScheduleRes coachWithScheduleRes = new CoachWithScheduleRes();
            coachWithScheduleRes.setCoach(coach);
            List<CoachSchedule> scheduleList = coachScheduleRepository.findByCoach(coach);
            coachWithScheduleRes.setSchedule(scheduleList);
            response.add(coachWithScheduleRes);
        }
        return response;
    }

    @Override
    public List<Coach> getListCoachHomepage() {
        List<Coach> coachList = coachRepository.findByStatus("Active");
        Collections.shuffle(coachList);
        if (coachList.size() > 8) {
            coachList = coachList.subList(0, 8);
        }
        return coachList;
    }

    @Override
    public void addCoach(CoachReq request) throws ParseException {
        Coach coach = new Coach();

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        String randomNumberString = stringBuilder.toString();
        coach.setCode("PT" + randomNumberString);

        coach.setName(request.getName());
        coach.setEmail(request.getEmail());
        coach.setPhone(request.getPhone());
        coach.setDob(dateFormat.parse(request.getDob()));
        coach.setImageUrl(request.getImageUrl());
        coach.setLevel(request.getLevel());
        coach.setExperience(request.getExperience());
        coach.setExpertise(request.getExpertise());
        coach.setCertification(request.getCertification());
        coach.setAchievements(request.getAchievements());
        coach.setDescription(request.getDescription());
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        coach.setGym(gym);
        coach.setStatus("Active");
        coach.setCreatedAt(new Date());
        coach.setUpdatedAt(new Date());
        coachRepository.save(coach);
    }

    @Override
    public void editCoach(String id, CoachReq request) throws ParseException {
        Coach coach = coachRepository.findById(id).orElseThrow();
        coach.setName(request.getName());
        coach.setEmail(request.getEmail());
        coach.setPhone(request.getPhone());
        coach.setDob(dateFormat.parse(request.getDob()));
        coach.setImageUrl(request.getImageUrl());
        coach.setLevel(request.getLevel());
        coach.setExperience(request.getExperience());
        coach.setExpertise(request.getExpertise());
        coach.setCertification(request.getCertification());
        coach.setAchievements(request.getAchievements());
        coach.setDescription(request.getDescription());
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        coach.setGym(gym);
        coach.setStatus(request.getStatus());
        coach.setUpdatedAt(new Date());
        coachRepository.save(coach);
    }

    @Override
    public Coach getCoachInfo(String id) {
        return coachRepository.findById(id).orElseThrow();
    }

    @Override
    public List<CoachSchedule> getScheduleOfCoach(String id) {
        Coach coach = coachRepository.findById(id).orElseThrow();
        return coachScheduleRepository.findByCoach(coach);
    }

    @Override
    public List<CoachSchedule> getBusyScheduleOfCoach(String id) {
        Coach coach = coachRepository.findById(id).orElseThrow();
        return coachScheduleRepository.findByCoachAndType(coach, "busy");
    }

    @Override
    public List<Member> getListMemberOfCoach(String id) {
        Coach coach = coachRepository.findById(id).orElseThrow();
        List<MemberService> memberServiceList = memberServiceRepository.findByCoachAndStatus(coach, "Active");
        return memberServiceList.stream().map(MemberService::getMember).toList();
    }

    @Override
    public void addSchedule(String coachId, CoachScheduleReq request) throws ParseException {
        CoachSchedule coachSchedule = new CoachSchedule();
        Coach coach = coachRepository.findById(coachId).orElseThrow();
        coachSchedule.setCoach(coach);
        coachSchedule.setTitle(request.getTitle());
        coachSchedule.setStartDate(datetimeFormat.parse(request.getStartDate()));
        coachSchedule.setEndDate(datetimeFormat.parse(request.getEndDate()));
        coachSchedule.setType(request.getType());
        coachSchedule.setDescription(request.getDescription());
        if (Objects.equals(request.getType(), "PT")) {
            Member member = memberRepository.findById(request.getMemberId()).orElseThrow();
            MemberService memberService = memberServiceRepository.findByCoachAndMemberAndStatus(coach, member, "Active");
            coachSchedule.setMemberService(memberService);
        }
        coachSchedule.setCreatedAt(new Date());
        coachSchedule.setUpdatedAt(new Date());
        coachScheduleRepository.save(coachSchedule);
    }

    @Override
    public CoachSchedule editSchedule(String id, CoachScheduleReq request) throws ParseException {
        CoachSchedule coachSchedule = coachScheduleRepository.findById(id).orElseThrow();
        Coach coach = coachSchedule.getCoach();

        coachSchedule.setTitle(request.getTitle());
        coachSchedule.setStartDate(datetimeFormat.parse(request.getStartDate()));
        coachSchedule.setEndDate(datetimeFormat.parse(request.getEndDate()));
        coachSchedule.setType(request.getType());
        coachSchedule.setDescription(request.getDescription());
        if (Objects.equals(request.getType(), "PT")) {
            Member member = memberRepository.findById(request.getMemberId()).orElseThrow();
            MemberService memberService = memberServiceRepository.findByCoachAndMemberAndStatus(coach, member, "Active");
            coachSchedule.setMemberService(memberService);
        }
        coachSchedule.setUpdatedAt(new Date());
        coachScheduleRepository.save(coachSchedule);
        return coachSchedule;
    }

    @Override
    public void deleteSchedule(String id) {
        CoachSchedule coachSchedule = coachScheduleRepository.findById(id).orElseThrow();
        coachScheduleRepository.delete(coachSchedule);
    }

    @Override
    public List<Coach> getOtherCoaches(String id) {
        List<Coach> coaches = coachRepository.findByStatus("Active");
        List<Coach> response = new ArrayList<>();
        coaches.removeIf(coach -> coach.getId().equals(id));
        Collections.shuffle(coaches);
        if (coaches.size() > 3) response = coaches.subList(0, 3);
        else response = coaches;
        return response;
    }
}
