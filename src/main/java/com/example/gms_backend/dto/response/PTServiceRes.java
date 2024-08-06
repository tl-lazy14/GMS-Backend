package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Coach;
import com.example.gms_backend.entity.CoachSchedule;
import com.example.gms_backend.entity.Membership;
import com.example.gms_backend.entity.PersonalTrainerPackage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PTServiceRes {
    private String id;
    private PersonalTrainerPackage service;
    private Date startDate;
    private Date expiredDate;
    private Coach trainer;
    private Integer hasResult;
    private String resultId;
    private String status;
    private List<CoachSchedule> schedule;
}
