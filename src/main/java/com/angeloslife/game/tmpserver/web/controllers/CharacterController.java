package com.angeloslife.game.tmpserver.web.controllers;

import com.angeloslife.game.tmpserver.TmpServerApplication;
import com.angeloslife.game.tmpserver.web.model.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
