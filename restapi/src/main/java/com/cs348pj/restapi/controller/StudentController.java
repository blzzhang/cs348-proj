package com.cs348pj.restapi.controller;


import com.cs348pj.restapi.dto.response.ReadableStudent;
import com.cs348pj.restapi.dto.request.RegisterStudentParam;
import com.cs348pj.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /** ListAll */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ReadableStudent>> listAll() throws Exception {
        return ok(studentService.listAll());
    }

    /** Registration */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ReadableStudent> register(@Validated @RequestBody RegisterStudentParam params) throws Exception {
        return new ResponseEntity<>(studentService.register(params), HttpStatus.CREATED);
    }

    /** Login through password */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ReadableStudent> login(@RequestParam("email") String email, @RequestParam("password") String passwrod) throws Exception {
        return ok(studentService.login(email, passwrod));
    }
}
