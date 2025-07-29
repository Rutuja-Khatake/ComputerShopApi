package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.nt")
public class StaterMainClass {

    public static void main(String[] args) {
        SpringApplication.run(StaterMainClass.class, args);
    }
	
}
						