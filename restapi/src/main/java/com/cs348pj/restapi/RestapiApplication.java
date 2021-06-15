package com.cs348pj.restapi;

import com.cs348pj.restapi.dto.CourseDto;
import com.cs348pj.restapi.repository.CourseRepository;
import com.cs348pj.restapi.util.DataLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

}
