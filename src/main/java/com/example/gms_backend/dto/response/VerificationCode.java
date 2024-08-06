package com.example.gms_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {
    private String code;
    private LocalDateTime expirationTime;

    public VerificationCode(int code, LocalDateTime expirationTime) {
        this.code = String.valueOf(code);
        this.expirationTime = expirationTime;
    }
}
