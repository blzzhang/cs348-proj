package com.cs348pj.restapi.dto.response;

import com.cs348pj.restapi.model.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ReadableStudent {
    private UUID id;
    private String name;
    private String major;
    private String createTime;

    public static ReadableStudent create(Student student) {
        ReadableStudent readableStudent = new ReadableStudent();
//        readableStudent.setId(student.getId());
        readableStudent.setName(student.getName());
        if(student.getMajor() != null) readableStudent.setMajor(student.getMajor());
        else readableStudent.setMajor("N/A");
        readableStudent.setCreateTime(student.getCreateTime().toString());
        return readableStudent;
    }

    public static List<ReadableStudent> createList(List<Student> students) {
        List<ReadableStudent> result = new ArrayList<>();
        for(Student student : students) result.add(ReadableStudent.create(student));
        return result;
    }
}
