package fr.umontpellier.iut.gui;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

@ServerEndpoint(value = "/")
public class WebSocketClient {
    private static final Gson gson = new Gson();

    @OnOpen
    public void onOpen(Session session) {
        GameServer.addClient(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            // Intentar convertir el mensaje en JSON para ver si es una configuración
            JsonObject jsonMessage;
            try {
                jsonMessage = gson.fromJson(message, JsonObject.class);
                if (jsonMessage.has("type")) {
                    // Es un mensaje de configuración, por ejemplo, desde la página inicial
                    String type = jsonMessage.get("type").getAsString();
                    if ("configureGame".equals(type)) {
                        System.out.println("mensaje para config le juego");
                        String[] players = gson.fromJson(jsonMessage.get("players"), String[].class);
                        String[] cards = gson.fromJson(jsonMessage.get("cards"), String[].class);
                        GameServer.configureGame(players, cards, session);
                    }
                } else {
                    // Si no tiene "type", lo tratamos como una entrada del juego
                    GameServer.addInput(message);
                }
            } catch (JsonSyntaxException e) {
                // Si el mensaje no es JSON válido, lo tratamos como una entrada del juego
                GameServer.addInput(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error mensaje cliente");
            // Manejo de error, podrías enviar un mensaje de error al cliente
        }
    }

    @OnClose
    public void onClose(Session session) {
        GameServer.removeClient(session);
    }
}