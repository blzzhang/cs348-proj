package com.cs348pj.restapi.controller;

import com.cs348pj.restapi.dto.response.ReadableReview;
import com.cs348pj.restapi.model.Course;
import com.cs348pj.restapi.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.internalServerError;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("instructors")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    /** populate the table using an endpoint **/
    @RequestMapping(value = "/populate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> populateTable() {
        try {
            instructorService.populate();
            return ok("Table Populated");
        } catch (Exception e) {
            return internalServerError().body("Table not populated");
        }
    }
    /** List all prof teaching a specific course */
    @RequestMapping(value = "/listAllForCourse", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Course>> listAllForCourse(@RequestParam("courseName") String courseName) throws Exception {
        return ok(instructorService.listAllForCourse(courseName));
    }
}
