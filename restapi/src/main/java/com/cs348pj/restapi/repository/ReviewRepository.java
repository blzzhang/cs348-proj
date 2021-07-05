package com.cs348pj.restapi.repository;

import com.cs348pj.restapi.model.Review;
import com.cs348pj.restapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    List<Review> findByEmail(String course);

    @Query(value = "select * from review where course_name = :courseName",
            nativeQuery = true)
    List<Review> listAllByCourseName(@Param("courseName") String courseName);
}
