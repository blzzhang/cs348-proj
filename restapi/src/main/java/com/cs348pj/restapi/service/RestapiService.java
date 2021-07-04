package com.cs348pj.restapi.service;

import com.cs348pj.restapi.dto.Course;

public interface RestapiService {

    void populateSample(Integer courseId, String title, String description);

    Iterable<Course> findAllById(String id);
}
