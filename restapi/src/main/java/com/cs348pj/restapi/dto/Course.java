package com.cs348pj.restapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {
    // TODO: change this to private after figuring out why LOMBOK getter/setter is NOT WORKING
    @Id
    public String courseId;

    // TODO: same thing
    public String title;
    private String detailedName;

    // TODO: same thing
    public String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    @JoinTable(
//            name = "course_instructor",
//            joinColumns = {@JoinColumn(name = "course_id", nullable = false, updatable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "instructor_id", nullable = false, updatable = false)})
    @Cascade({
            org.hibernate.annotations.CascadeType.DETACH,
            org.hibernate.annotations.CascadeType.LOCK,
            org.hibernate.annotations.CascadeType.REFRESH,
            org.hibernate.annotations.CascadeType.REPLICATE
    })
    private Set<Instructor> instructor;
    private String location;
    private boolean majorOnly;

    @ManyToMany
    private Set<Course> prereqs;
}
