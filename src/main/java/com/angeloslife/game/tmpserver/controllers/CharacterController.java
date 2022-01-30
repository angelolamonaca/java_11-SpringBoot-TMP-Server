package com.angeloslife.game.tmpserver.controllers;

import com.angeloslife.game.tmpserver.TmpServerApplication;
import com.angeloslife.game.tmpserver.model.Character;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 22/01/2022
 */

@RestController
public class CharacterController {

    @GetMapping("/character/position")
    String getPosition() {
        Map<String, Integer> position = new HashMap<>();
        position.put("x", 6);
        position.put("y", 0);
        position.put("z", 0);

        Gson gson = new Gson();
        return gson.toJson(position);
    }

    @PostMapping(value = "/character/add", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<HttpStatus> postPosition(@RequestBody Character character) {
        TmpServerApplication.world.getCharacterList().add(character);
        return ResponseEntity
                .ok(HttpStatus.OK);
    }
}
