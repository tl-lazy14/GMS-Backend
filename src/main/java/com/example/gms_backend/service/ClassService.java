package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.ClassReq;
import com.example.gms_backend.dto.response.ListClassCategoryRes;
import com.example.gms_backend.dto.response.ListExerciseCategoryRes;
import com.example.gms_backend.entity.Class;
import com.example.gms_backend.entity.ClassCategory;
import com.example.gms_backend.entity.Member;
import com.example.gms_backend.entity.MemberService;

import java.text.ParseException;
import java.util.List;

public interface ClassService {
    List<ListClassCategoryRes> getAllCategories();
    ClassCategory getCategory(String id);
    void addCategory(String name);
    void editCategory(String id, String name);
    void deleteCategory(String id);
    List<Class> getListClass(String gymId, String categoryId);
    void addClass(ClassReq request) throws ParseException;
    void editClass(String id, ClassReq request) throws ParseException;
    void deleteClass(String id);
    List<Member> getListParticipant(String id);
    List<Member> getListAvailableMemberForAddToClass(String classId);
    Class addMemberToClass(String classId, String memberId);
    Class removeMemberFromClass(String classId, String memberId);
}
