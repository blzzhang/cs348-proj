package com.cs348pj.restapi.service.impl;

import com.cs348pj.restapi.constants.RestApiConstants;
import com.cs348pj.restapi.model.Course;
import com.cs348pj.restapi.model.Instructor;
import com.cs348pj.restapi.repository.InstructorRepository;
import com.cs348pj.restapi.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    public List<Course> listAllForCourse(String courseName) throws Exception{
        List<Course> courses = new ArrayList<>();
        return courses;
    }

    @Override
    public void populate() throws Exception {
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
                    newClass = true;
                } else if (newClass) {
                    String [] n = l.split(",");
                    if (!term.equals(n[0]) || !sub.equals(n[1]) || !cat.equals(n[2])) {
                        term = n[0];
                        sub = n[1];
                        cat = n[2];
                    }
                    newClass = false;
                } else {
                    inst.add(l);
                }
            }

            for (String i : inst) {
                Instructor ins = new Instructor();
                ins.setName(i);
                instructorRepository.save(ins);
            }
        } catch (IOException e) {
            System.err.println("Error adding instructors");
            throw e;
        }
    }
}
