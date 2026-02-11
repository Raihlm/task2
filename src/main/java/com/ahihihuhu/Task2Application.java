package com.ahihihuhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
@RestController
public class Task2Application {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(Task2Application.class, args);
    }

    @GetMapping
    public String menyapaDunia(){
        return "Assalamualaikum Dunia";
    }

}
