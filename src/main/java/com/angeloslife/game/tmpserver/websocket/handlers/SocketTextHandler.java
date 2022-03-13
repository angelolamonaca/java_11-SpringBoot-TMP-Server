package com.angeloslife.game.tmpserver.websocket.handlers;

import com.angeloslife.game.tmpserver.websocket.models.Greeting;
import com.angeloslife.game.tmpserver.websocket.models.HelloMessage;
import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 13/03/2022
 */
@Component
public class SocketTextHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException, JSONException {

        Thread.sleep(1000); // simulated delay
        String payload = message.getPayload();
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        HelloMessage helloMessage = gson.fromJson(payload, HelloMessage.class); // de
        session.sendMessage(new TextMessage("Hi " + helloMessage.getName() + " how may we help you?"));

    }

}
