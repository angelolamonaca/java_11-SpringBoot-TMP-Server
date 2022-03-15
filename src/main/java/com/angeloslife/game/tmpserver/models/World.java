package com.angeloslife.game.tmpserver.models;

import lombok.ToString;

import java.util.HashSet;

/**
 * Represents the whole online world
 *
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 29/01/2022
 */
@ToString
public class World {
    public static final HashSet<Long> ONLINE_USERS = new HashSet<>();
}
