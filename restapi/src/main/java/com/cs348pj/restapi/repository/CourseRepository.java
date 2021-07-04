package com.cs348pj.restapi.repository;

import com.cs348pj.restapi.dto.Course;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// TODO: change CourseDto to Entity model
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into course (course_id, title, description) values (:courseId, :name, :desc)",
    nativeQuery = true)
    void populateSample(
            @Param("courseId") Integer courseId,
            @Param("name") String title,
            @Param("desc") String desc);
}
