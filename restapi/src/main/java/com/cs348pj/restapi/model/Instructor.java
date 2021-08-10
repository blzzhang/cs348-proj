package com.cs348pj.restapi.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Instructor {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;

//    private Integer id;
    @NotNull
    private String name;

//    @ManyToMany
//    private Set<Course> courses;
}
