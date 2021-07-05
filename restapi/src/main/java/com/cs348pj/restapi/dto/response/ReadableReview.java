package com.cs348pj.restapi.dto.response;

import com.cs348pj.restapi.model.Review;
import com.cs348pj.restapi.model.Student;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReadableReview {
    private String courseName;
    private String rating;
    private String liked;
    private String useful;
    private String easy;
    private String interesing;
    private String wellStructured;
    private String description;
    private String createTime;

    public static ReadableReview create(Review review) {
        ReadableReview readableReview = new ReadableReview();
        readableReview.setCourseName(review.getCourseName());
        readableReview.setRating(review.getRating());
        readableReview.setLiked(review.getLiked());
        if(review.getUseful() != null) readableReview.setUseful(review.getUseful());
        else readableReview.setUseful("N/A");
        if(review.getEasy() != null) readableReview.setEasy(review.getEasy());
        else readableReview.setEasy("N/A");
        if(review.getInteresing() != null) readableReview.setInteresing(review.getInteresing());
        else readableReview.setInteresing("N/A");
        if(review.getWellStructured() != null) readableReview.setWellStructured(review.getWellStructured());
        else readableReview.setWellStructured("N/A");
        if(review.getDescription() != null) readableReview.setDescription(review.getDescription());
        else readableReview.setDescription("N/A");
        readableReview.setCreateTime(review.getCreateTime().toString());
        return readableReview;
    }

    public static List<ReadableReview> createList(List<Review> reviews) {
        List<ReadableReview> result = new ArrayList<>();
        for(Review review : reviews) result.add(ReadableReview.create(review));
        return result;
    }
}
