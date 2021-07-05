package com.cs348pj.restapi.service;

import com.cs348pj.restapi.dto.response.ReadableStudent;
import com.cs348pj.restapi.dto.request.RegisterStudentParam;
import java.util.List;

public interface StudentService {
    ReadableStudent register(RegisterStudentParam params) throws Exception;

    ReadableStudent login(String email, String password) throws Exception;

    List<ReadableStudent> listAll() throws Exception;
}
