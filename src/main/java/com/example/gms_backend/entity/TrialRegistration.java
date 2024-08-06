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
@Table(name = "trial_registrations")
public class TrialRegistration {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private String timeContact;
    private String statusContact;
    private String statusApprove;
    private Date preferredDate;
    private Date createdAt;
    private Date updatedAt;
}
