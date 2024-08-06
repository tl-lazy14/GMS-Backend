package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.ErrorRes;
import com.example.gms_backend.dto.response.GetListUserRes;
import com.example.gms_backend.entity.User;
import com.example.gms_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/info")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.getUserInfo(userDetails.getUsername());
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserReq request) {
        try {
            userService.createUser(request);
            return ResponseEntity.ok().body("User created successfully!");
        } catch (Exception e) {
            ErrorRes errorResponse = ErrorRes.builder().error(e.getMessage()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/get-list-gym-managers")
    public ResponseEntity<GetListUserRes> getListGymManagers(@RequestParam String keyword,
                                                             @RequestParam int page) {
        GetListUserReq req = new GetListUserReq(keyword, page);
        GetListUserRes response = userService.getListGymManagers(req);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") String id) {
        User response = userService.getUserById(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/edit-user/{id}")
    public void editUser(@PathVariable(value = "id") String id, @RequestBody EditUserReq request) throws ParseException {
        userService.editUser(id, request);
    }

    @DeleteMapping("/delete-user/{id}")
    public void editUser(@PathVariable(value = "id") String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/export-list-gym-managers")
    public ResponseEntity<List<User>> exportListGymManagers() {
        List<User> response = userService.exportListGymManagers();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/edit-profile/{id}")
    public ResponseEntity<User> editProfile(@PathVariable(value = "id") String id,
                                            @RequestBody EditProfileReq request) throws ParseException {
        User user = userService.editProfile(id, request);
        return ResponseEntity.ok().body(user);
    }
}
