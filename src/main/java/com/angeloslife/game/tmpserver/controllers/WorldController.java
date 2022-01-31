package com.angeloslife.game.tmpserver.controllers;

import com.angeloslife.game.tmpserver.TmpServerApplication;
import com.angeloslife.game.tmpserver.model.Character;
import com.angeloslife.game.tmpserver.model.World;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 22/01/2022
 */

@Slf4j
@RestController
public class WorldController {

    @GetMapping("/world/get")
    String getWorld() {
        World world = TmpServerApplication.world;
        log.info("Getting World" + world.toString());

        Gson gson = new Gson();
        return gson.toJson(world);
    }
}
