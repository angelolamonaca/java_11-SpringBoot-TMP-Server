package com.angeloslife.game.tmpserver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a User (a character in game)
 *
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 29/01/2022
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    Long id;
    Position position;
}
