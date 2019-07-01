package com.kafein.kbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(KbookApplication.class, args);
    }

}
