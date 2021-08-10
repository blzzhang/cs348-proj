package com.cs348pj.restapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Instructor {
    @Id
    private Integer id;
    private String name;

//    @ManyToMany
//    private Set<Course> courses;
}
