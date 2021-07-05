package com.cs348pj.restapi.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStudentParam {
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String name;
}
