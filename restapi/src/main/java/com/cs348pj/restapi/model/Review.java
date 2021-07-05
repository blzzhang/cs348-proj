package com.cs348pj.restapi.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/** Consumer */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
//    private Instructor instructor;
    @NotNull
    @Column(name = "course_name")
    private String courseName;

    @NotNull
    @Column(name = "rating")
    private String rating;

    @NotNull
    @Column(name = "liked")
    private String liked;

    @Column(name = "useful")
    private String useful;

    @Column(name = "easy")
    private String easy;

    @Column(name = "interesting")
    private String interesing;

    @Column(name = "well_structured")
    private String wellStructured;

    @Column(name = "description")
    private String description;

    @Column(name = "email")
    private String email;

    @Column(name = "create_time")
    private Date createTime;
}
