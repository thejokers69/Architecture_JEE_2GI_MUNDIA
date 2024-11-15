package org.example.student_app_mohamed_lakssir;

import org.example.student_app_mohamed_lakssir.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class    StudentAppMohamedLakssirApplication {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(StudentAppMohamedLakssirApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception{

    }

}
