package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.ChangePasswordReq;
import com.example.gms_backend.dto.request.CreateUserReq;
import com.example.gms_backend.dto.request.LoginReq;
import com.example.gms_backend.dto.response.LoginRes;
import com.example.gms_backend.dto.response.VerificationCode;
import com.example.gms_backend.entity.Gym;
import com.example.gms_backend.entity.User;
import com.example.gms_backend.repository.UserRepository;
import com.example.gms_backend.service.AuthenticationService;
import com.example.gms_backend.service.EmailService;
import com.example.gms_backend.service.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final EmailService emailService;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final Map<String, VerificationCode> verificationCodes = new HashMap<>();

    @Override
    public LoginRes login(LoginReq request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        System.out.println(accessToken);
        System.out.println(refreshToken);

        // Lưu token vào HTTP-only cookie
        Cookie accessTokenCookie = new Cookie("accessToken", accessToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setSecure(true); // Sử dụng true nếu là môi trường production với HTTPS
        response.addCookie(accessTokenCookie);

        Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setSecure(true); // Sử dụng true nếu là môi trường production với HTTPS
        response.addCookie(refreshTokenCookie);

        return LoginRes.builder()
                .user(user)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public String refreshAccessToken(String refreshToken, HttpServletResponse response) {
        String userEmail = jwtService.extractUsername(refreshToken);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
        if (userEmail != null && jwtService.isTokenValid(refreshToken, userDetails)) {
            String newAccessToken = jwtService.generateAccessToken(userDetails);
            Cookie accessTokenCookie = new Cookie("accessToken", newAccessToken);
            accessTokenCookie.setHttpOnly(true);
            accessTokenCookie.setPath("/");
            accessTokenCookie.setSecure(true); // Sử dụng true nếu là môi trường production với HTTPS
            response.addCookie(accessTokenCookie);
            System.out.println("Access token moi la: " + newAccessToken);
            return newAccessToken;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        throw new RuntimeException("Refresh token is invalid!");
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // Xóa cookie chứa refresh token
        Cookie refreshTokenCookie = new Cookie("refreshToken", null);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setMaxAge(0); // Đặt thời gian sống là 0 để xóa cookie
        response.addCookie(refreshTokenCookie);

        // Xóa cookie chứa access token (nếu có)
        Cookie accessTokenCookie = new Cookie("accessToken", null);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setMaxAge(0);
        response.addCookie(accessTokenCookie);
    }

    @Override
    public void forgotPassword(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Email does not exist!");
        }
        SecureRandom random = new SecureRandom();
        int code = 100000 + random.nextInt(900000);
        VerificationCode verificationCode = new VerificationCode(code, LocalDateTime.now().plusMinutes(1));
        verificationCodes.put(email, verificationCode);
        emailService.sendVerificationCode(email, String.valueOf(code));
    }

    @Override
    public void verifyCode(String email, String code) {
        VerificationCode verificationCode = verificationCodes.get(email);
        if (verificationCode == null || verificationCode.getExpirationTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Verification code is invalid or has expired!");
        }
        if (!verificationCode.getCode().equals(code)) {
            throw new RuntimeException("Verification code is incorrect!");
        }
    }

    @Override
    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email).orElseThrow();
        String hashedNewPassword = bCryptPasswordEncoder.encode(newPassword);
        user.setPassword(hashedNewPassword);
        userRepository.save(user);
    }

    @Override
    public void changePassword(String id, ChangePasswordReq request) {
        User user = userRepository.findById(id).orElseThrow();
        if (!bCryptPasswordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new RuntimeException("Current password is incorrect!");
        }
        String newPassword = request.getNewPassword();
        String hashedNewPassword = bCryptPasswordEncoder.encode(newPassword);

        user.setPassword(hashedNewPassword);
        userRepository.save(user);
    }
}
