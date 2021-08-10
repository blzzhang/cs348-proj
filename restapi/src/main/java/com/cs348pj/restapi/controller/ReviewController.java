package com.cs348pj.restapi.controller;

import com.cs348pj.restapi.dto.response.ReadableReview;
import com.cs348pj.restapi.dto.response.ReadableStudent;
import com.cs348pj.restapi.dto.request.ReviewRequestParam;
import com.cs348pj.restapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    /** List Review for a course, id is course's id */
    @RequestMapping(value = "/listAllForCourse", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ReadableReview>> listAllForCourse(@RequestParam("courseName") String courseName) throws Exception {
        return ok(reviewService.listAll(courseName));
    }

    /** get average rating for a course */
    @RequestMapping(value = "/getAvarageRating", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Double> getAvarageRating(@RequestParam("courseName") String courseName) throws Exception {
        return ok(reviewService.getAvarageRating(courseName));
    }

    //TODO
//    /** List Review for a instructor */
//    @RequestMapping(value = "/listAllForInstructor", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<List<ReadableStudent>> listAll() throws Exception {
//        return ok(studentService.listAll());
//    }

    /** Add a review from a student, id is student's id */
    @RequestMapping(value = "/{id}/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ReadableReview> add(@PathVariable UUID id,
                                              @Validated @RequestBody ReviewRequestParam params) throws Exception {
        return new ResponseEntity<>(reviewService.add(params, id), HttpStatus.CREATED);
    }

    //TODO
//    /** delete a review */
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<ReadableStudent> register(@Validated @RequestBody RegisterStudentParam params) throws Exception {
//        return new ResponseEntity<>(studentService.register(params), HttpStatus.CREATED);
//    }
}
