package com.angeloslife.game.tmpserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 29/01/2022
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
public class World {
    List<Character> characterList;
}
