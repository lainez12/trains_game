package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.GestionJeu;
import fr.umontpellier.iut.trainsJavaFX.IJoueur;
import fr.umontpellier.iut.trainsJavaFX.TrainsIHM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VueResultats extends Pane {

    private TrainsIHM ihm ;

    @FXML
    private Label gagnant;
    @FXML
    private Label autresJoueurs;
    public VueResultats(TrainsIHM ihm) {
        this.ihm = ihm;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VueResultats.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void creeBiding() {
        Optional<? extends IJoueur> joueurAvecLePlusGrandScore = GestionJeu.getJeu().getJoueurs().stream()
                .max(Comparator.comparingInt(IJoueur::getScoreTotal));

        if (joueurAvecLePlusGrandScore.isPresent()) {
            IJoueur joueur = joueurAvecLePlusGrandScore.get();
            gagnant.setText(joueur.getNom() + " a gagné avec " + joueur.getScoreTotal() + " points.");
        } else {
            int maxScore = GestionJeu.getJeu().getJoueurs().stream()
                    .mapToInt(IJoueur::getScoreTotal)
                    .max()
                    .orElse(0);

            List<IJoueur> joueursAvecLePlusGrandScore = GestionJeu.getJeu().getJoueurs().stream()
                    .filter(joueur -> joueur.getScoreTotal() == maxScore)
                    .collect(Collectors.toList());

            if (!joueursAvecLePlusGrandScore.isEmpty()) {
                gagnant.setText("Les suivants joueurs : ");
                for (IJoueur joueur : joueursAvecLePlusGrandScore) {
                    gagnant.setText(gagnant.getText() + joueur.getNom() + " ");
                }
                gagnant.setText(gagnant.getText() + "ont gagné avec " + maxScore + " points.");
            }
        }
    }
}
