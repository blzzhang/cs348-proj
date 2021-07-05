package com.cs348pj.restapi.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ReviewRequestParam {
    @NotNull
    private String courseName;

    @NotNull
    private String rating;

    @NotNull
    private String liked;

    private String useful;
    private String easy;
    private String interesing;
    private String wellStructured;
    private String description;
}
