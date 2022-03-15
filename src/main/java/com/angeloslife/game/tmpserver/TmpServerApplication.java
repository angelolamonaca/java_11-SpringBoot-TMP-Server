package com.angeloslife.game.tmpserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TmpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmpServerApplication.class, args);
        System.out.println("Started");
    }

}
