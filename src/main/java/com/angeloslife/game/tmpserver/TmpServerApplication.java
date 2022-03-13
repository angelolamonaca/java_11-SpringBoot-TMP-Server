package com.angeloslife.game.tmpserver;

import com.angeloslife.game.tmpserver.web.model.Character;
import com.angeloslife.game.tmpserver.web.model.Position;
import com.angeloslife.game.tmpserver.web.model.World;
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

        List<Character> characterList = new ArrayList<>();

        Character characterA = new Character(0, new Position(2, 0, 0));
        characterList.add(characterA);
        world = new World(characterList);
    }

}
