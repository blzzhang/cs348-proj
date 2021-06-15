package com.cs348pj.restapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class CourseDto {
    // TODO: change this to private after figuring out why LOMBOK getter/setter is NOT WORKING
    public String courseId;

    // TODO: same thing
    public String title;
    private String detailedName;

    // TODO: same thing
    public String description;
    private InstructorDto instructor;
    private String location;
    private boolean majorOnly;
    private Set<CourseDto> prereqs;
}
