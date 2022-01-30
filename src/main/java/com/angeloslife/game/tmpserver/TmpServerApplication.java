package com.angeloslife.game.tmpserver;

import com.angeloslife.game.tmpserver.model.Character;
import com.angeloslife.game.tmpserver.model.World;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TmpServerApplication {

    public static World world;
    public static void main(String[] args) {
        SpringApplication.run(TmpServerApplication.class, args);

        System.out.println("Started");
        world = new World(new ArrayList<>());
    }

}
