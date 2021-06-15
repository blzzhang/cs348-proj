package com.cs348pj.restapi.repository;

import com.cs348pj.restapi.dto.CourseDto;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// TODO: change CourseDto to Entity model
public interface CourseRepository extends CrudRepository<CourseDto, Integer> {

    @Modifying
    @Query(value = "insert into course (courseId, name, description) values (:courseId, :name, :desc)",
    nativeQuery = true)
    public void populateSample(
            @Param("courseId") String courseId,
            @Param("name") String title,
            @Param("desc") String desc);
}
