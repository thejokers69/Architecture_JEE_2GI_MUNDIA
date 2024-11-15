package org.example.student_app_mohamed_lakssir;

import org.example.student_app_mohamed_lakssir.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
@SpringBootApplication
public class    StudentAppMohamedLakssirApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(StudentAppMohamedLakssirApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // Custom logic to run after application startup can go here
    }

}
