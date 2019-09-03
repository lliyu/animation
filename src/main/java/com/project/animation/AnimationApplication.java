package com.project.animation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.project.animation.mapper")
@SpringBootApplication
public class AnimationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimationApplication.class, args);
    }

}
