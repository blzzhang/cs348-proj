package com.cs348pj.restapi.repository;

import com.cs348pj.restapi.model.Course;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into course values (:courseId, :career, :catalog, :desc, null, :subject, :term, :title)",
    nativeQuery = true)
    void populateSample(
            @Param("courseId") Integer courseId,
            @Param("career") String career,
            @Param("title") String title,
            @Param("desc") String desc,
            @Param("term") String term,
            @Param("subject") String subject,
            @Param("catalog") String catalog);

    @Modifying
    @Transactional
    @Query(value = "update course set instructors = :instructors where term_code = :term and subject_code = :sub and catalog_number = :catalog",
    nativeQuery = true)
    void addInstructors(@Param("term") String term,
                        @Param("sub") String subject,
                        @Param("catalog") String catalog,
                        @Param("instructors") String instructors);
}
