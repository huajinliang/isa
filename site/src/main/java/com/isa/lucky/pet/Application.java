package com.isa.lucky.pet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.isa.lucky.pet.dao.mapper"})
public class Application extends SpringApplication {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

}
