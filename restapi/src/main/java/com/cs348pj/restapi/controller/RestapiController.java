package com.cs348pj.restapi.controller;

import com.cs348pj.restapi.model.Course;
import com.cs348pj.restapi.service.RestapiService;
import com.cs348pj.restapi.util.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class RestapiController {

    @Autowired
    private RestapiService restapiService;

    @PostMapping("/populate")
    public @ResponseBody
    String populateTable() throws Exception {
        DataLoader dl = new DataLoader();
        List<Course> courses = dl.getCoursesBySubject("1215", "CS");
        for (Course course : courses) {
            restapiService.populateSample(
                    course.getCourseId(),
                    course.getAssociatedAcademicCareer(),
                    course.getTitle(),
                    course.getDescription(),
                    course.getTermCode(),
                    course.getSubjectCode(),
                    course.getCatalogNumber());
        }
        return "populated";
    }

    @PostMapping("/instructors")
    public @ResponseBody
    String addInstructors() {
        restapiService.addInstructors();
        return "instructors added";
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Iterable<Course> getClassById(@PathVariable String id) {
        return restapiService.findAllById(id);
    }
}

