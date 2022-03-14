package com.angeloslife.game.tmpserver.web.controllers;

import com.angeloslife.game.tmpserver.TmpServerApplication;
import com.angeloslife.game.tmpserver.web.model.Character;
import com.angeloslife.game.tmpserver.web.model.World;
import com.angeloslife.game.tmpserver.websocket.handlers.OnlineCharactersHandler;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;

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
    ResponseEntity<HttpStatus> postPosition(@RequestBody Character character) throws IOException {
        TmpServerApplication.world.getCharacterList().add(character);
        log.info("Adding Character to World " + character.toString());


        World world = TmpServerApplication.world;
        log.info("Getting World" + world.toString());

        Gson gson = new Gson();
        gson.toJson(world);
        OnlineCharactersHandler.onlineCharactersSession.get(0L).sendMessage(new TextMessage(gson.toJson(world)));

        return ResponseEntity
                .ok(HttpStatus.OK);
    }
}
