package com.cs348pj.restapi.controller;

import com.cs348pj.restapi.dto.CourseDto;
import com.cs348pj.restapi.repository.CourseRepository;
import com.cs348pj.restapi.util.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class RestapiController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/populate")
    public @ResponseBody
    String populateTable() {
        DataLoader dl = new DataLoader();
        CourseDto course = dl.getCourseById("1215", "004417");
        courseRepository.populateSample(course.courseId, course.title, course.description);
        return "populated";
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Iterable<CourseDto> getClassById(@PathVariable String id) {
        return courseRepository.findAllById(List.of(Integer.parseInt(id)));
    }
}

