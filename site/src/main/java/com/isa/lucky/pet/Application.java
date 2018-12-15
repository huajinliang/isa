package com.isa.lucky.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application extends SpringApplication {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

}
