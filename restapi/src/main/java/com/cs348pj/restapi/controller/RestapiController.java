package com.cs348pj.restapi.controller;

import com.cs348pj.restapi.dto.Course;
import com.cs348pj.restapi.service.RestapiService;
import com.cs348pj.restapi.util.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("courses")
public class RestapiController {

    @Autowired
    private RestapiService restapiService;

    @PostMapping("/populate")
    public @ResponseBody
    String populateTable() {
        DataLoader dl = new DataLoader();
        Course course = dl.getCourseById("1215", "004417");
        restapiService.populateSample(course.courseId, course.title, course.description);
        return "populated";
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Iterable<Course> getClassById(@PathVariable String id) {
        return restapiService.findAllById(id);
    }
}

