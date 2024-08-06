package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.CategoryReq;
import com.example.gms_backend.dto.request.ClassReq;
import com.example.gms_backend.dto.response.ErrorRes;
import com.example.gms_backend.dto.response.ListClassCategoryRes;
import com.example.gms_backend.dto.response.ListExerciseCategoryRes;
import com.example.gms_backend.entity.Class;
import com.example.gms_backend.entity.ClassCategory;
import com.example.gms_backend.entity.Member;
import com.example.gms_backend.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @GetMapping("/get-list-category")
    public ResponseEntity<List<ListClassCategoryRes>> getListClassCategory() {
        List<ListClassCategoryRes> response = classService.getAllCategories();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-category/{id}")
    public ResponseEntity<ClassCategory> getClassCategory(@PathVariable(value = "id") String id) {
        ClassCategory response = classService.getCategory(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-category")
    public ResponseEntity<?> addClassCategory(@RequestBody CategoryReq request) {
        try {
            classService.addCategory(request.getName());
            return ResponseEntity.ok().body("Success");
        } catch (Exception e) {
            ErrorRes errorResponse = ErrorRes.builder().error(e.getMessage()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/edit-category/{id}")
    public ResponseEntity<?> editClassCategory(@PathVariable(value = "id") String id,
                                               @RequestBody CategoryReq request) {
        try {
            classService.editCategory(id, request.getName());
            return ResponseEntity.ok().body("Success");
        } catch (Exception e) {
            ErrorRes errorResponse = ErrorRes.builder().error(e.getMessage()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<String> deleteClassCategory(@PathVariable String id) {
        classService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully!");
    }

    @GetMapping("/get-list-class")
    public ResponseEntity<List<Class>> getListClass(@RequestParam String gymId,
                                                    @RequestParam String categoryId) {
        List<Class> response = classService.getListClass(gymId, categoryId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-class")
    public void addClass(@RequestBody ClassReq request) throws ParseException {
        classService.addClass(request);
    }

    @PutMapping("/edit-class/{id}")
    public void editClass(@PathVariable(value = "id") String id,
                          @RequestBody ClassReq request) throws ParseException {
        classService.editClass(id, request);
    }

    @DeleteMapping("/delete-class/{id}")
    public void deleteClass(@PathVariable(value = "id") String id) {
        classService.deleteClass(id);
    }

    @GetMapping("/get-list-participant/{classId}")
    public ResponseEntity<List<Member>> getListParticipant(@PathVariable(value = "classId") String classId) {
        List<Member> response = classService.getListParticipant(classId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-list-available-mem/{classId}")
    public ResponseEntity<List<Member>> getListAvailableMemForAddToClass(@PathVariable(value = "classId") String classId) {
        List<Member> response = classService.getListAvailableMemberForAddToClass(classId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add-member-to-class/{classId}/{memberId}")
    public ResponseEntity<Class> addMemberToClass(@PathVariable(value = "classId") String classId,
                                                  @PathVariable(value = "memberId") String memberId) {
        Class response = classService.addMemberToClass(classId, memberId);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/remove-member-from-class/{classId}/{memberId}")
    public ResponseEntity<Class> removeMemberFromClass(@PathVariable(value = "classId") String classId,
                                      @PathVariable(value = "memberId") String memberId) {
        Class response = classService.removeMemberFromClass(classId, memberId);
        return ResponseEntity.ok().body(response);
    }
}
