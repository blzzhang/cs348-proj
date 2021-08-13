package com.cs348pj.restapi.service;

import com.cs348pj.restapi.model.Course;

public interface RestapiService {

    void populateSample(Integer courseId, String career, String title,
                        String description, String term, String subject, String Catalog) throws Exception;

    Iterable<Course> findAllById(String id);

    void addInstructors();

    Iterable<Course> findByCourseCode(String subject, String catalog);
}
