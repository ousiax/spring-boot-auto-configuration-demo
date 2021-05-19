package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloApp {
    public static void main(String[] args) {
        SpringApplication.run(HelloApp.class, args);
    }

    @Bean
    CommandLineRunner helloWinterRunner(Hello hi) {
        return args -> {
            // Hello Autumn!
            hi.hello();
        };
    }
}
