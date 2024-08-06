package com.example.gms_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workout_results")
public class WorkoutResult {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @ManyToOne
    @JoinColumn(name = "member_service_id")
    private MemberService memberService;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private Integer numWeeks;
    private String imageUrl;
    private String preIssues;
    private String shareContent;
    private String description;
    private String measurement;
    private String programDescription;
    private String nutritionPlan;
    private Date createdAt;
    private Date updatedAt;
}
