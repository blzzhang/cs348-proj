package com.cs348pj.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
    @Id
    private Integer courseId;

    private String associatedAcademicCareer;

    private String catalogNumber;

    @Column(length = 2048)
    private String description;

    private String subjectCode;

    private String termCode;

    private String title;

    @Column(length = 2048)
    private String instructors;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
////    @JoinTable(
////            name = "course_instructor",
////            joinColumns = {@JoinColumn(name = "course_id", nullable = false, updatable = false)},
////            inverseJoinColumns = {@JoinColumn(name = "instructor_id", nullable = false, updatable = false)})
//    @Cascade({
//            org.hibernate.annotations.CascadeType.DETACH,
//            org.hibernate.annotations.CascadeType.LOCK,
//            org.hibernate.annotations.CascadeType.REFRESH,
//            org.hibernate.annotations.CascadeType.REPLICATE
//    })
//    private Set<Instructor> instructor;
//    private String location;
//    private boolean majorOnly;
//
//    @ManyToMany
//    private Set<Course> prereqs;
}
