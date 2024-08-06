package com.example.gms_backend.dto.response;

import com.example.gms_backend.entity.Coach;
import com.example.gms_backend.entity.CoachSchedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoachWithScheduleRes {
    private Coach coach;
    private List<CoachSchedule> schedule;
}
