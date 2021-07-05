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
@Table(name = "student")
public class Student {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "uw_student_id")
    private String uwStudentId;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "major")
    private String major;

    @Column(name = "year")
    private String year;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "status")
    private Integer status;
}
