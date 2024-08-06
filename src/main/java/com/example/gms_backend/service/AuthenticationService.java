package com.example.gms_backend.service;

import com.example.gms_backend.dto.request.ChangePasswordReq;
import com.example.gms_backend.dto.request.CreateUserReq;
import com.example.gms_backend.dto.request.LoginReq;
import com.example.gms_backend.dto.response.LoginRes;
import com.example.gms_backend.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.ParseException;

public interface AuthenticationService {
    LoginRes login(LoginReq request, HttpServletResponse httpServletResponse);
    String refreshAccessToken(String refreshToken, HttpServletResponse response);
    void logout(HttpServletRequest request, HttpServletResponse response);
    void forgotPassword(String email);
    void verifyCode(String email, String code);
    void resetPassword(String email, String newPassword);
    void changePassword(String id, ChangePasswordReq request);
}
