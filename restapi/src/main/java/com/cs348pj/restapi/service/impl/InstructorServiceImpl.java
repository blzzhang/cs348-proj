package com.cs348pj.restapi.service.impl;

import com.cs348pj.restapi.model.Course;
import com.cs348pj.restapi.repository.InstructorRepository;
import com.cs348pj.restapi.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    public List<Course> listAllForCourse(String courseName) throws Exception{
        List<Course> courses = new ArrayList<>();
        return courses;
    }
}
