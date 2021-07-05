package com.cs348pj.restapi.service.impl;

import com.cs348pj.restapi.dto.response.ReadableStudent;
import com.cs348pj.restapi.dto.request.RegisterStudentParam;
import com.cs348pj.restapi.model.Student;
import com.cs348pj.restapi.repository.StudentRepository;
import com.cs348pj.restapi.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired private StudentRepository repository;

    @Override
    public ReadableStudent register(RegisterStudentParam params) throws Exception{
//        Optional<Student> exsitedStudent = repository.findByEmail(params.getEmail());
//        if (exsitedStudent.isPresent()) {
//            throw new Exception("Email already exsited");
//        }

        Student newStudent = new Student();
//        BeanUtils.copyProperties(params, newStudent);
        newStudent.setCreateTime(new Date());
        newStudent.setEmail(params.getEmail());
        newStudent.setName(params.getName());
        newStudent.setPassword(params.getPassword());
        repository.save(newStudent);
        return ReadableStudent.create(newStudent);
    }

    public ReadableStudent login(String email, String password) throws Exception{
        Optional<Student> student = repository.findByEmail(email);
        if(student.isEmpty()) throw new Exception("Email doesn't exist");
        if(!student.get().getPassword().equals(password)) throw new Exception("Credential doesn't match");
        //TODO: Add JWT TOKEN for login
        return ReadableStudent.create(student.get());
    }

    public List<ReadableStudent> listAll() throws Exception{
        List<Student> students = repository.findAll();
        return ReadableStudent.createList(students);
    }
}
