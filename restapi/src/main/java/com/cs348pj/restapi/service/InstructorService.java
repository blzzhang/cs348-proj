package com.cs348pj.restapi.service;

import com.cs348pj.restapi.dto.response.ReadableReview;
import com.cs348pj.restapi.model.Course;

import java.util.List;

public interface InstructorService {
    List<Course> listAllForCourse(String courseName) throws Exception;
}
