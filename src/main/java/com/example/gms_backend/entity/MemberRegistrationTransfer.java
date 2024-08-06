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
@Table(name = "member_registration_transfers")
public class MemberRegistrationTransfer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private Date dob;
    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;
    private Date startDate;
    private Date endDate;
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
