package com.cs348pj.restapi.service.impl;

import com.cs348pj.restapi.constants.RestApiConstants;
import com.cs348pj.restapi.model.Course;
import com.cs348pj.restapi.repository.CourseRepository;
import com.cs348pj.restapi.service.RestapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

@Service("restapiService")
public class RestapiServiceImpl implements RestapiService {

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void populateSample(Integer courseId, String career, String title,
                               String description, String term, String subject, String catalog) throws Exception {
        System.out.println("Populating the DB with courseID: " + courseId + " " + subject + catalog);

        try {
            List<String> lines = new ArrayList<>();
            Path file = Paths.get(RestApiConstants.COURSE_LIST);
            lines.add(term);
            lines.add(subject);
            lines.add(catalog);
            if (career.equals("GRD")) {
                lines.add("grad");
            } else {
                lines.add("under");
            }
            Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Writing to file failed");
            throw e;
        }
        courseRepository.populateSample(courseId, career, title, description, term, subject, catalog);
    }

    @Override
    public void addInstructors() {
        Path path = Paths.get(RestApiConstants.INST_FILE_PATH);
        try (Stream<String> st = Files.lines(path)) {
            List<String> lines = new ArrayList<>();
            Set<String> inst = new HashSet<>();

            st.forEach(lines::add);

            boolean newClass = true;
            String term = "";
            String sub = "";
            String cat = "";

            for (String l : lines) {
                if (l.equals("<END>")) {
                    courseRepository.addInstructors(term, sub, cat, inst.toString());
                    newClass = true;
                } else if (newClass) {
                    String [] n = l.split(",");
                    if (!term.equals(n[0]) || !sub.equals(n[1]) || !cat.equals(n[2])) {
                        inst = new HashSet<>();
                        term = n[0];
                        sub = n[1];
                        cat = n[2];
                    }
                    newClass = false;
                } else {
                    inst.add(l);
                }
            }
        } catch (IOException e) {
            System.err.println("Error adding instructors");
        }
    }

    @Override
    public Iterable<Course> findAllById(String id) {
        return courseRepository.findAllById(List.of(Integer.parseInt(id)));
    }


    public Iterable<Course> findByCourseCode(String subject, String catalog) {
        return courseRepository.findByCourseCode(subject, catalog);
    }
}
