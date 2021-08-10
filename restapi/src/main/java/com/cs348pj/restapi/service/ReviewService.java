package com.cs348pj.restapi.service;

import com.cs348pj.restapi.dto.request.RegisterStudentParam;
import com.cs348pj.restapi.dto.request.ReviewRequestParam;
import com.cs348pj.restapi.dto.response.ReadableReview;
import com.cs348pj.restapi.dto.response.ReadableStudent;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    ReadableReview add(ReviewRequestParam params, UUID studentId) throws Exception;

    List<ReadableReview> listAll(String courseName) throws Exception;

    Double getAvarageRating(String courseName) throws Exception;
}
