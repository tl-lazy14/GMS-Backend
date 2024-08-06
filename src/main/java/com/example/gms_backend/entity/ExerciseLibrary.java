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
@Table(name = "exercise_libraries")
public class ExerciseLibrary {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String title;
    private String description;
    private String thumbnail;
    private String youtubeUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ExerciseCategory exerciseCategory;
    private String level;
    private Date createdAt;
    private Date updatedAt;
}
