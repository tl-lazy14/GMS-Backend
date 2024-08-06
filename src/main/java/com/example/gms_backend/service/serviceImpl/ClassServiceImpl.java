package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.ClassReq;
import com.example.gms_backend.dto.response.ListClassCategoryRes;
import com.example.gms_backend.dto.response.ListExerciseCategoryRes;
import com.example.gms_backend.entity.*;
import com.example.gms_backend.entity.Class;
import com.example.gms_backend.repository.*;
import com.example.gms_backend.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final CoachRepository coachRepository;
    private final CoachScheduleRepository coachScheduleRepository;
    private final ClassRepository classRepository;
    private final ClassCategoryRepository classCategoryRepository;
    private final ClassMemberRepository classMemberRepository;
    private final GymRepository gymRepository;
    private final MemberServiceRepository memberServiceRepository;
    private final MemberRepository memberRepository;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<ListClassCategoryRes> getAllCategories() {
        List<ClassCategory> categoryList = classCategoryRepository.findAll();

        List<ListClassCategoryRes> res = new ArrayList<>();
        for (ClassCategory category : categoryList) {
            List<Class> listClassofCategory = classRepository.findByClassCategory(category);

            ListClassCategoryRes categoryRes = ListClassCategoryRes.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .quantity(listClassofCategory.size())
                    .build();
            res.add(categoryRes);
        }
        return res;
    }

    @Override
    public ClassCategory getCategory(String id) {
        return classCategoryRepository.findById(id).orElseThrow();
    }

    @Override
    public void addCategory(String name) {
        Optional<ClassCategory> categoryExist = classCategoryRepository.findByName(name);
        if (categoryExist.isPresent()) {
            throw new RuntimeException("Category name already exists!");
        }
        ClassCategory newCategory = new ClassCategory();
        newCategory.setName(name);
        newCategory.setCreatedAt(new Date());
        newCategory.setUpdatedAt(new Date());
        classCategoryRepository.save(newCategory);
    }

    @Override
    public void editCategory(String id, String name) {
        ClassCategory classCategory = classCategoryRepository.findById(id).orElseThrow();

        Optional<ClassCategory> categoryExist = classCategoryRepository.findByName(name);
        if (categoryExist.isPresent() && !categoryExist.get().getId().equals(id)) {
            throw new RuntimeException("Category name already exists!");
        }
        classCategory.setName(name);
        classCategory.setUpdatedAt(new Date());
        classCategoryRepository.save(classCategory);
    }

    @Override
    public void deleteCategory(String id) {
        ClassCategory classCategory = classCategoryRepository.findById(id).orElseThrow();
        classCategoryRepository.delete(classCategory);
    }

    @Override
    public List<Class> getListClass(String gymId, String categoryId) {
        Gym gym = gymRepository.findById(gymId).orElseThrow();
        ClassCategory classCategory = classCategoryRepository.findById(categoryId).orElseThrow();
        return classRepository.findByGymAndClassCategory(gym, classCategory);
    }

    @Override
    public void addClass(ClassReq request) throws ParseException {
        Class aClass = new Class();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10); // Random digit from 0 to 9
            sb.append(digit);
        }
        aClass.setCode(sb.toString());
        aClass.setTitle(request.getTitle());
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        aClass.setGym(gym);
        aClass.setStartDate(datetimeFormat.parse(request.getStartDate()));
        aClass.setEndDate(datetimeFormat.parse(request.getEndDate()));
        Coach coach = coachRepository.findById(request.getCoachId()).orElseThrow();
        aClass.setCoach(coach);
        aClass.setDescription(request.getDescription());
        ClassCategory category = classCategoryRepository.findById(request.getCategoryId()).orElseThrow();
        aClass.setClassCategory(category);
        aClass.setMaxParticipants(request.getMaxParticipants());
        aClass.setCurrentParticipants(0);
        aClass.setCreatedAt(new Date());
        aClass.setUpdatedAt(new Date());
        classRepository.save(aClass);

        CoachSchedule coachSchedule = new CoachSchedule();
        coachSchedule.setCoach(coach);
        coachSchedule.setTitle(request.getTitle());
        coachSchedule.setStartDate(datetimeFormat.parse(request.getStartDate()));
        coachSchedule.setEndDate(datetimeFormat.parse(request.getEndDate()));
        coachSchedule.setType("class");
        coachSchedule.setDescription(request.getDescription());
        coachSchedule.setAClass(aClass);
        coachSchedule.setCreatedAt(new Date());
        coachSchedule.setUpdatedAt(new Date());
        coachScheduleRepository.save(coachSchedule);
    }

    @Override
    public void editClass(String id, ClassReq request) throws ParseException {
        Class aClass = classRepository.findById(id).orElseThrow();
        CoachSchedule currentCoachSchedule = coachScheduleRepository.findByClass(aClass.getId());
        aClass.setTitle(request.getTitle());
        aClass.setStartDate(datetimeFormat.parse(request.getStartDate()));
        aClass.setEndDate(datetimeFormat.parse(request.getEndDate()));
        aClass.setDescription(request.getDescription());
        aClass.setMaxParticipants(request.getMaxParticipants());
        aClass.setUpdatedAt(new Date());

        if (!Objects.equals(request.getCoachId(), aClass.getCoach().getId())) {
            coachScheduleRepository.delete(currentCoachSchedule);

            Coach coach = coachRepository.findById(request.getCoachId()).orElseThrow();
            aClass.setCoach(coach);
            classRepository.save(aClass);

            CoachSchedule coachSchedule = new CoachSchedule();
            coachSchedule.setCoach(coach);
            coachSchedule.setTitle(request.getTitle());
            coachSchedule.setStartDate(datetimeFormat.parse(request.getStartDate()));
            coachSchedule.setEndDate(datetimeFormat.parse(request.getEndDate()));
            coachSchedule.setType("class");
            coachSchedule.setDescription(request.getDescription());
            coachSchedule.setAClass(aClass);
            coachSchedule.setCreatedAt(new Date());
            coachSchedule.setUpdatedAt(new Date());
            coachScheduleRepository.save(coachSchedule);
        } else {
            classRepository.save(aClass);
        }
    }

    @Override
    public void deleteClass(String id) {
        Class aClass = classRepository.findById(id).orElseThrow();
        List<ClassMember> classMemberList = classMemberRepository.findByClass(aClass.getId());
        classMemberRepository.deleteAll(classMemberList);
        CoachSchedule coachSchedule = coachScheduleRepository.findByClass(aClass.getId());
        coachScheduleRepository.delete(coachSchedule);
        classRepository.delete(aClass);
    }

    @Override
    public List<Member> getListParticipant(String id) {
        List<ClassMember> classMemberList = classMemberRepository.findByClass(id);
        return classMemberList.stream().map((ClassMember::getMember)).toList();
    }

    @Override
    public List<Member> getListAvailableMemberForAddToClass(String classId) {
        Class aClass = classRepository.findById(classId).orElseThrow();
        return memberServiceRepository.getListAvailableMemberForAddToClass(aClass.getGym().getId(), aClass.getStartDate());
    }

    @Override
    public Class addMemberToClass(String classId, String memberId) {
        Class aClass = classRepository.findById(classId).orElseThrow();
        int currentParticipants = aClass.getCurrentParticipants();
        aClass.setCurrentParticipants(currentParticipants + 1);
        classRepository.save(aClass);

        Member member = memberRepository.findById(memberId).orElseThrow();
        ClassMember classMember = new ClassMember();
        classMember.setMember(member);
        classMember.setAClass(aClass);
        classMember.setCreatedAt(new Date());
        classMember.setUpdatedAt(new Date());
        classMemberRepository.save(classMember);
        return aClass;
    }

    @Override
    public Class removeMemberFromClass(String classId, String memberId) {
        ClassMember classMember = classMemberRepository.findByClassAndMember(classId, memberId);
        classMemberRepository.delete(classMember);

        Class aClass = classRepository.findById(classId).orElseThrow();
        int currentParticipants = aClass.getCurrentParticipants();
        aClass.setCurrentParticipants(currentParticipants - 1);
        classRepository.save(aClass);
        return aClass;
    }
}
