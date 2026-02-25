package com.lld.websocket;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatHandler extends TextWebSocketHandler {

    private static final Set<WebSocketSession> sessions =
            ConcurrentHashMap.newKeySet();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        System.out.println("Client connected: " + session.getId());
    }

    // CLIENT → SERVER
    @Override
    protected void handleTextMessage(
            WebSocketSession session,
            TextMessage message) throws Exception {

        System.out.println("Received: " + message.getPayload());

        // SERVER → CLIENT (broadcast)
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(
                        new TextMessage("Echo: " + message.getPayload())
                );
            }
        }
    }

    @Override
    public void afterConnectionClosed(
            WebSocketSession session,
            CloseStatus status) {

        sessions.remove(session);
        System.out.println("Client disconnected: " + session.getId());
    }
}
