package com.angeloslife.game.tmpserver.websocket.handlers;

import com.angeloslife.game.tmpserver.TmpServerApplication;
import com.angeloslife.game.tmpserver.web.model.World;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 13/03/2022
 */
@Slf4j
@Component
public class OnlineCharactersHandler extends TextWebSocketHandler {

    public static HashMap<String, WebSocketSession> onlineCharactersSession = new HashMap<>();

    /**
     * TODO Check the bearer token authenticity
     * In order to establish a connection, a bearer token is required
     * The bearer token should be present in the web socket connection request Headers
     *
     * @param session web socket session opened by the client
     * @throws IOException thrown by session.sendMessage
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        List<String> authorizationHeader = session.getHandshakeHeaders().get("authorization");
        if (authorizationHeader != null) {
            String bearerToken = authorizationHeader.get(0);
            onlineCharactersSession.put(bearerToken, session);
            session.sendMessage(new TextMessage("Connection successful established with auth bearer: " + bearerToken));
        } else {
            session.sendMessage(new TextMessage("There is no Bearer token in the request Headers, please add the authorization header like 'Authorization: Bearer asd123'"));
            session.close(CloseStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException, JSONException {

        Thread.sleep(1000); // simulated delay
        String payload = message.getPayload();
        log.info("OnlineCharactersHandler Payload: " + payload);

        World world = TmpServerApplication.world;
        log.info("Getting World" + world.toString());

        Gson gson = new Gson();
        gson.toJson(world);
        session.sendMessage(new TextMessage(gson.toJson(world)));

    }

}
