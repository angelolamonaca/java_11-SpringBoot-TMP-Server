package com.angeloslife.game.tmpserver.websocket.handlers;

import com.angeloslife.game.tmpserver.models.Position;
import com.angeloslife.game.tmpserver.models.User;
import com.angeloslife.game.tmpserver.models.World;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 13/03/2022
 */
@Slf4j
@Component
public class OnlineUsersHandler extends TextWebSocketHandler {

    public static final HashMap<Long, WebSocketSession> onlineUsersSessions = new HashMap<>();
    static Gson gson = new Gson();

    /**
     * TODO Check the bearer token authenticity
     * In order to establish a connection, a bearer token is required
     * The bearer token should be present in the web socket connection request Headers
     * The client will receive his last position
     *
     * @param session web socket session opened by the client
     * @throws IOException thrown by session.sendMessage
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        List<String> authorizationHeader = session.getHandshakeHeaders().get("authorization");
        if (authorizationHeader != null) {
            String bearerToken = authorizationHeader.get(0);

            // TODO Extract userId from bearer token
            Long userId = 42L;
            log.debug("Extracted userId {%s} from bearer token: {%s}".formatted(userId, bearerToken));

            // TODO Fetch user from database
            User user = new User(userId, new Position(5, 0, 0));
            Position userPosition = user.getPosition();
            log.debug("Fetched userId {%s} position: {%s}".formatted(userId, userPosition));

            onlineUsersSessions.put(userId, session);
            log.debug("userId {%s} successful added in OnlineUsersHandler.onlineUsersSessions set".formatted(userId));

            World.ONLINE_USERS.add(userId);
            log.debug("userId {%s} successful added in World.ONLINE_USERS set".formatted(userId));

            log.info("Websocket connection successful established with userId: " + userId);

            log.debug("Sending user object");
            session.sendMessage(new TextMessage(gson.toJson(user)));
        } else {
            session.sendMessage(new TextMessage("There is no Bearer token in the request Headers, please add the authorization header like 'Authorization: Bearer asd123'"));
            log.error("There is no Bearer token in the request Headers, please add the authorization header like 'Authorization: Bearer asd123'");
            session.close(CloseStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        List<String> authorizationHeader = session.getHandshakeHeaders().get("authorization");
        if (authorizationHeader != null) {
            String bearerToken = authorizationHeader.get(0);

            // TODO Extract userId from bearer token
            Long userId = 42L;
            log.debug("Extracted userId {%s} from bearer token: {%s}".formatted(userId, bearerToken));

            onlineUsersSessions.remove(userId);
            log.debug("userId {%s} successful removed from OnlineUsersHandler.onlineUsersSessions set".formatted(userId));

            World.ONLINE_USERS.remove(userId);
            log.debug("userId {%s} successful removed from World.ONLINE_USERS set".formatted(userId));

            log.info("Websocket connection successful closed with userId: " + userId);
        } else {
            log.error("There is no Bearer token in the request Headers, trying to remove the user by session");

            Iterator<Map.Entry<Long, WebSocketSession>> iterator = onlineUsersSessions.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, WebSocketSession> entry = iterator.next();
                if (session.equals(entry.getValue())) {
                    Long userId = entry.getKey();

                    if (World.ONLINE_USERS.remove(userId))
                        log.debug("userId {%s} successful removed from OnlineUsersHandler.onlineUsersSessions set".formatted(userId));
                    else
                        log.error("Trying to remove userId {%s} from OnlineUsersHandler.onlineUsersSessions set but it's not contained".formatted(userId));

                    iterator.remove();
                    log.info("Websocket connection successful closed with userId: " + userId);
                    return;
                }
            }
            log.error("Attempting to close an unregistered websocket connection (session not present in onlineUsersSessions)");
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {

        String payload = message.getPayload();
        log.info("OnlineCharactersHandler Payload: " + payload);


    }

}
