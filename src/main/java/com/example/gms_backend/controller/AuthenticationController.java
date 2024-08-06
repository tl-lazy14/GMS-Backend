package com.example.gms_backend.controller;

import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.ErrorRes;
import com.example.gms_backend.dto.response.LoginRes;
import com.example.gms_backend.entity.User;
import com.example.gms_backend.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginRes> login(@RequestBody LoginReq request, HttpServletResponse response) {
        LoginRes authResponse = authenticationService.login(request, response);
        return ResponseEntity.ok().body(authResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshAccessToken(@CookieValue(value = "refreshToken", required = false) String refreshToken, HttpServletResponse response) {
        if (refreshToken == null) {
            System.out.println("Khong co refresh token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not authenticated!");
        }
        String newToken = authenticationService.refreshAccessToken(refreshToken, response);
        return ResponseEntity.ok().body(Collections.singletonMap("newAccessToken", newToken));
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        authenticationService.logout(request, response);
    }

    @PostMapping("/forgot-password")
    public void forgotPassword(@RequestBody EmailReq request) {
        authenticationService.forgotPassword(request.getEmail());
    }

    @PostMapping("/verify-code")
    public void verifyCode(@RequestBody VerifyCodeReq request) {
        authenticationService.verifyCode(request.getEmail(), request.getCode());
    }

    @PutMapping("/reset-password")
    public void resetPassword(@RequestBody ResetPasswordReq request) {
        authenticationService.resetPassword(request.getEmail(), request.getNewPassword());
    }

    @PutMapping("/change-password/{id}")
    public ResponseEntity<?> changePassword(@PathVariable(value = "id") String id,
                               @RequestBody ChangePasswordReq request) {
        try {
            authenticationService.changePassword(id, request);
            return ResponseEntity.ok().body("Change password successful!");
        } catch (Exception e) {
            ErrorRes errorResponse = ErrorRes.builder().error(e.getMessage()).build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
