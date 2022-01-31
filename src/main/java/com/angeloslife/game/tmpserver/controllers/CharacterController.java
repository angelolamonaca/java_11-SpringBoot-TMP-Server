package com.angeloslife.game.tmpserver.controllers;

import com.angeloslife.game.tmpserver.TmpServerApplication;
import com.angeloslife.game.tmpserver.model.Character;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 22/01/2022
 */

@Slf4j
@RestController
public class CharacterController {

    @PostMapping(value = "/character/add", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<HttpStatus> postPosition(@RequestBody Character character) {
        TmpServerApplication.world.getCharacterList().add(character);
        log.info("Adding Character to World " + character.toString());
        return ResponseEntity
                .ok(HttpStatus.OK);
    }
}
