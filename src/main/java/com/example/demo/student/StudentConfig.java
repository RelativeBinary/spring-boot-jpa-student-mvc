package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean //it is instantiated when the program is started
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student studentA = new Student(
                    "studentA",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "sA@e.st");

            Student studentB = new Student(
                    "studentB",
                    LocalDate.of(2005, Month.JANUARY, 5),
                    "sB@e.st");
            studentRepository.saveAll(List.of(studentA,studentB));

        };
    }
}
