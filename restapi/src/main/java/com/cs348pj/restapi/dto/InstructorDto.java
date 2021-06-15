package com.cs348pj.restapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InstructorDto {
    private String id;
    private String name;

    InstructorDto(String id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Instructor with name "+ name + " and id " + id + "created");
    }
}
