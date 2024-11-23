package fr.umontpellier.iut.gui;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import fr.umontpellier.iut.gui.JeuWebsocket;
import fr.umontpellier.iut.trains.plateau.Plateau;
import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;
import javax.websocket.Session;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class GameServer {
    private static final ArrayList<Session> clients = new ArrayList<>();
    private static final ArrayList<Session> spectators = new ArrayList<>();
    private static String etatJeu = "";
    private static JeuWebsocket jeu;
    private static Server server;

    // Variable para saber si el juego ya está configurado
    private static boolean isGameConfigured = false;

    public static void main(String[] args) throws IOException, DeploymentException {
        // SERVEUR HTTP (para servir el frontend)
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(4242), 0);
        httpServer.createContext("/", new StaticFileHandler("/", "front/", "index.html"));
        httpServer.start();

        // SERVEUR WEBSOCKET (para comunicar entre el frontend y el backend)
        GameServer.server = new Server("localhost", 3232, "/", WebSocketClient.class);
        server.start();

        System.out.println("Servidor listo. Esperando configuración del juego...");
       /* String[] nomsJoueurs = { "Guybrush", "Largo" };

        // Liste des cartes à utiliser :
        String[] nomsCartes = { "Aiguillage", "Passage en gare", "Décharge" };
        GameServer.configureGame(nomsJoueurs,nomsCartes,null);*/
    }

    public static void configureGame(String[] joueurs, String[] cartes, Session cliente) {
        if (!isGameConfigured) {
            // Configurar los jugadores y las cartas
            jeu = new JeuWebsocket(joueurs, cartes, Plateau.OSAKA);
            isGameConfigured = true;
            System.out.println("Juego configurado exitosamente con los jugadores: " + String.join(", ", joueurs));

            // Iniciar el juego en un nuevo hilo
            new Thread(jeu).start();

            // Configurar un Timer para enviar periódicamente el estado del juego
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        String estado = new Gson().toJson(jeu.dataMap()); // Asumimos que dataMap() devuelve el estado del juego
                        setEtatJeu(estado);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 2000); // Enviar el estado cada 2 segundos

            // Enviar mensaje de confirmación a los clientes conectados
            try {
                for (Session session : clients) {
                    session.getBasicRemote().sendText("gameConfigured");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            if (clients.size() == 0) {
                jeu.estFini();
            }
        } else {
            spectators.remove(session);
        }
    }

    public static void setEtatJeu(String etatJeu) {
        GameServer.etatJeu = etatJeu;
        // Envoie l'état de la partie à tous les clients
        try {
            for (Session session : clients) {
                session.getBasicRemote().sendText(etatJeu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
