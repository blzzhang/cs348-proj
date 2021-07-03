package com.cs348pj.restapi.service.impl;

import com.cs348pj.restapi.dto.Course;
import com.cs348pj.restapi.repository.CourseRepository;
import com.cs348pj.restapi.service.RestapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("restapiService")
public class RestapiServiceImpl implements RestapiService {

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void populateSample(String courseId, String title, String description) {
        courseRepository.populateSample(courseId, title, description);
    }

    @Override
    public Iterable<Course> findAllById(String id) {
        return courseRepository.findAllById(List.of(Integer.parseInt(id)));
    }
}
