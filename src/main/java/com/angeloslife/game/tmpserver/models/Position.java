package com.angeloslife.game.tmpserver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Similar to Vector3 object, represents a position in a 3D space
 *
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 15/03/2022
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Position {
    private float x;
    private float y;
    private float z;
}
