package com.cs348pj.restapi.service.impl;

import com.cs348pj.restapi.dto.request.ReviewRequestParam;
import com.cs348pj.restapi.dto.response.ReadableReview;
import com.cs348pj.restapi.model.Review;
import com.cs348pj.restapi.model.Student;
import com.cs348pj.restapi.repository.ReviewRepository;
import com.cs348pj.restapi.repository.StudentRepository;
import com.cs348pj.restapi.service.ReviewService;
import com.cs348pj.restapi.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired private ReviewRepository repository;

    @Autowired StudentRepository studentRepository;

    @Override
    public ReadableReview add(ReviewRequestParam params, UUID studentId) throws Exception {
        Review review = new Review();
        review.setCreateTime(new Date());
        BeanUtils.copyProperties(params, review);
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isEmpty()) throw new Exception("the user does not exist");
        review.setStudent(student.get());
        repository.save(review);
        return ReadableReview.create(review);
    }

    public List<ReadableReview> listAll(String courseName) throws Exception {
        List<Review> reviews = repository.listAllByCourseName(courseName);
        return ReadableReview.createList(reviews);
    }
}
