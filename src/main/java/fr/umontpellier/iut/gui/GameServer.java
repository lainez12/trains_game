package fr.umontpellier.iut.gui;

import com.sun.net.httpserver.HttpServer;
import fr.umontpellier.iut.gui.JeuWebsocket;
import fr.umontpellier.iut.trains.plateau.Plateau;
import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;
import javax.websocket.Session;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class GameServer {
    private static final ArrayList<Session> clients = new ArrayList<>();
    private static final ArrayList<Session> spectators = new ArrayList<>();
    private static String etatJeu = "";
    private static JeuWebsocket jeu;

    // Variable para saber si el juego ya está configurado
    private static boolean isGameConfigured = false;

    public static void main(String[] args) throws IOException, DeploymentException {
        // SERVEUR HTTP (para servir el frontend)
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(4242), 0);
        httpServer.createContext("/", new StaticFileHandler("/", "front/", "index.html"));
        httpServer.start();

        // SERVEUR WEBSOCKET (para comunicar entre el frontend y el backend)
        Server server = new Server("localhost", 3232, "/", WebSocketClient.class);
        server.start();

        System.out.println("Servidor listo. Esperando configuración del juego...");
    }

    public static void configureGame(String[] joueurs, String[] cartes, Session cliente) {
        if (!isGameConfigured) {
            // Configurar los jugadores y las cartas
            jeu = new JeuWebsocket(joueurs, cartes, Plateau.OSAKA);
            isGameConfigured = true;
            System.out.println("Juego configurado exitosamente con los jugadores: " + String.join(", ", joueurs));

            // Enviar notificación de que el juego ha comenzado (opcional)
            setEtatJeu("El juego ha sido configurado y está listo para comenzar.");

            // Enviar mensaje de confirmación a los clientes conectados
            clients.add(cliente);
            try {
                for (Session session : clients) {

                    session.getBasicRemote().sendText("gameConfigured");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                jeu.run();
            }).start();
        }
    }

    public static void addClient(Session session) {
        if (isGameConfigured && clients.size() < jeu.getNombreJoueurs()) {
            clients.add(session);
            try {
                session.getBasicRemote().sendText(etatJeu);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Los clientes adicionales serán tratados como espectadores
            spectators.add(session);
            try {
                session.getBasicRemote().sendText(etatJeu);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addInput(String message) {
        if (isGameConfigured) {
            jeu.addInput(message);
        } else {
            System.out.println("El juego aún no está configurado. Esperando configuración...");
        }
    }

    public static void removeClient(Session session) {
        if (clients.remove(session)) {
            System.out.println("Jugador salio");
        } else {
            spectators.remove(session);
        }
    }

    public static void setEtatJeu(String etatJeu) {
        GameServer.etatJeu = etatJeu;
        try {
            for (Session session : clients) {
                session.getBasicRemote().sendText(etatJeu);
            }
            for (Session session : spectators) {
                session.getBasicRemote().sendText(etatJeu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
