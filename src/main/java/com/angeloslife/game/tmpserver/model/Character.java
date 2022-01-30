package com.angeloslife.game.tmpserver.model;

import lombok.*;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 29/01/2022
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Character {

    @NonNull
    int id;

    Position position;
}

class Position {
    float x;
    float y;
    float z;
}
