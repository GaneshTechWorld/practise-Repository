package com.wipro.M2M_Student_Course;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class M2MStudentCourseApplication {
	public static void main(String[] args) {
		SpringApplication.run(M2MStudentCourseApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
