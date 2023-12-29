package com.example.studyspringboot;

import com.example.studyspringboot.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.studyspringboot.mapper")
@SpringBootApplication
public class StudySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudySpringBootApplication.class, args);
    }
}
