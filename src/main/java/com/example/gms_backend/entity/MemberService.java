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
@Table(name = "member_services")
public class MemberService {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "workout_service_id")
    private Membership membership;
    @ManyToOne
    @JoinColumn(name = "pt_service_id")
    private PersonalTrainerPackage personalTrainerPackage;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;
    private Double amount;
    private String status;
    private Integer isSentMail;
    private Date createdAt;
    private Date updatedAt;
}
