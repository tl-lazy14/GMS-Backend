package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {
    private User user;
    private String accessToken;
    private String refreshToken;
}
