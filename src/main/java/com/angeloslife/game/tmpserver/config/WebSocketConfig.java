package com.angeloslife.game.tmpserver.config;

import com.angeloslife.game.tmpserver.websocket.handlers.SocketTextHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

/**
 * @author Angelo Lamonaca (https://www.angelolamonaca.com/)
 * @version 1.0
 * @since 13/03/2022
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SocketTextHandler(), "/user");
    }

}
