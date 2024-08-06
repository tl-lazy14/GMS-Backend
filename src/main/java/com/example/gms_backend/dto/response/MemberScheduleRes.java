package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Class;
import com.example.gms_backend.entity.Coach;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberScheduleRes {
    private String type;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private Coach trainer;
    private Class aClass;
}
