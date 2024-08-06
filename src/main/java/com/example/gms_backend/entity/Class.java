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
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String code;
    private String title;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ClassCategory classCategory;
    private Integer maxParticipants;
    private Integer currentParticipants;
    private Date createdAt;
    private Date updatedAt;
}
