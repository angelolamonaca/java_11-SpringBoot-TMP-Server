package com.angeloslife.game.tmpserver.web.controllers;

import com.angeloslife.game.tmpserver.TmpServerApplication;
import com.angeloslife.game.tmpserver.web.model.World;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
