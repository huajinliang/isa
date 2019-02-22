/**
 * Copyright (C) 2006-2019 Isa All rights reserved
 */
package com.isa.lucky.pet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.isa.lucky.pet.dao.mapper")
public class Application extends SpringApplication {

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

}
