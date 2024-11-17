package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.GestionJeu;
import fr.umontpellier.iut.trainsJavaFX.IJoueur;
import fr.umontpellier.iut.trainsJavaFX.mecanique.cartes.Carte;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

import java.io.IOException;

/**
 * Cette classe présente les éléments appartenant au joueur courant.
 * <p>
 * On y définit les bindings sur le joueur courant, ainsi que le listener à exécuter lorsque ce joueur change
 */
public class VueJoueurCourant extends FlowPane {

    @FXML
    private HBox cartesEnMain;
    @FXML
    private HBox cartesEnJeu;
    @FXML
    private Label argent;
    @FXML
    private Label score;
    @FXML
    private Label nbJetonsRailsRestants;
    @FXML
    public Label pointsRails;
    @FXML
    private HBox cartesRecues;

    @FXML
    private Button passer;

    @FXML
    private HBox cartesAChoisir;

    @FXML
    private Label deffausse;
    @FXML
    private Label piocher;
    @FXML
    private Label gares;
    @FXML
    private Label aChoisir;
    @FXML
    private Label textRecu;
    @FXML
    private Label textEnJeu;

    /*private EventHandler gestionnaireDeClic = event  -> {
        Button sourceButton = (Button) event.getSource();
        GestionJeu.getJeu().joueurCourantProperty().get().uneCarteDeLaMainAEteChoisie(sourceButton.getText());
        System.out.println(sourceButton.getText());
    };*/

    private ListChangeListener<Carte> cartesEnMainListener = change -> {
        while (change.next()) {
            if (change.wasRemoved()) {
                for (Carte removedCarte : change.getRemoved()) {
                    VueCarte c = trouverCarteRemove(removedCarte, cartesEnMain);
                    if (c != null) {
                        cartesEnMain.getChildren().remove(c);
                    }
                }
            } else if (change.wasAdded()) {
                for (Carte carteUsed : change.getAddedSubList()) {
                    VueCarte b = new VueCarte(carteUsed);
                    b.setOnMouseClicked(
                            mouseEvent -> {
                                GestionJeu.getJeu().joueurCourantProperty().get().uneCarteDeLaMainAEteChoisie(b.getCarte().getNom());
                            }
                    );
                    b.setTaille(0.40);
                    if (!cartesEnMain.getChildren().contains(b)) {
                        cartesEnMain.getChildren().add(b);
                    }
                }

            }
        }
    };

    private ListChangeListener<Carte> cartesAChoisirListener = change -> {
        while (change.next()) {
            aChoisir.setText("Choisir une carte");
            if (change.wasAdded()) {
                for (Carte carteUsed : change.getAddedSubList()) {
                    VueCarte b = new VueCarte(carteUsed);
                    b.setTaille(0.3);
                    b.setOnMouseClicked(
                            mouseEvent -> {
                                GestionJeu.getJeu().uneCarteAChoisirChoisie(b.getCarte().getNom());
                            }
                    );
                    if (!cartesAChoisir.getChildren().contains(b)) {
                        cartesAChoisir.getChildren().add(b);
                    }
                }
            } else if (change.wasRemoved()) {
                for (Carte removedCarte : change.getRemoved()) {
                    VueCarte c = trouverCarteRemove(removedCarte, cartesAChoisir);
                    if (c != null) {
                        cartesAChoisir.getChildren().remove(c);
                    }
                }

            }
        }
    };

    private ListChangeListener<Carte> cartesEnJeuListener = change -> {
        while (change.next()) {
            textEnJeu.setText("Cartes en jeu");
            if (change.wasAdded()) {
                for (Carte carteUsed : change.getAddedSubList()) {
                    VueCarte b = new VueCarte(carteUsed);
                    b.setOnMouseClicked(
                            mouseEvent -> {
                                GestionJeu.getJeu().joueurCourantProperty().get().uneCarteEnJeuAEteChoisie(b.getCarte().getNom());
                            }
                    );
                    if (!cartesEnJeu.getChildren().contains(b)) {
                        cartesEnJeu.getChildren().add(b);
                    }
                }
            } else if (change.wasRemoved()) {
                for (Carte removedCarte : change.getRemoved()) {
                    VueCarte c = trouverCarteRemove(removedCarte, cartesEnJeu);
                    if (c != null) {
                        cartesEnJeu.getChildren().remove(c);
                    }
                }

            }
        }
    };

    private ListChangeListener<Carte> cartesRecuesListener = change -> {
        while (change.next()) {
            textRecu.setText("Cartes reçues");
            if (change.wasAdded()) {
                for (Carte carteUsed : change.getAddedSubList()) {
                    VueCarte b = new VueCarte(carteUsed);
                    if (!cartesRecues.getChildren().contains(b)) {
                        cartesRecues.getChildren().add(b);
                    }
                }
            }
        }
    };

    public VueCarte trouverCarteRemove(Carte carteATrouver, HBox cartes) {
        for (Node node : cartes.getChildren()) {
            if (node instanceof VueCarte) {
                VueCarte c = (VueCarte) node;
                if (c.getCarte().getNom().equals(carteATrouver.getNom())) {
                    return c;
                }
            }
        }
        return null;
    }

    public VueJoueurCourant() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VueJoueurCourant.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creerBindings() {
        //Pour gere les cartes en main, jeu et reçu, on ajoute un listener sur les propriétés de chaque joueur
        for (IJoueur joueur : GestionJeu.getJeu().getJoueurs()) {
            joueur.mainProperty().addListener(cartesEnMainListener);
            joueur.cartesEnJeuProperty().addListener(cartesEnJeuListener);
            joueur.cartesRecuesProperty().addListener(cartesRecuesListener);
            joueur.cartesAChoisir().addListener(cartesAChoisirListener);
        }
        //Pour les cartes en main
        GestionJeu.getJeu().joueurCourantProperty().addListener((observable, vieux, nouveau) -> {
            textRecu.setText("");
            aChoisir.setText("");
            textEnJeu.setText("");
            cartesEnMain.getChildren().clear();
            for (Carte s : observable.getValue().mainProperty().getValue()) {
                VueCarte b = new VueCarte(s);
                b.setOnMouseClicked(
                        mouseEvent -> {
                            GestionJeu.getJeu().joueurCourantProperty().get().uneCarteDeLaMainAEteChoisie(b.getCarte().getNom());
                        }
                );
                b.setTaille(0.40);
                cartesEnMain.getChildren().add(b);
                cartesRecues.getChildren().clear();
                cartesEnJeu.getChildren().clear();
                setBackground(Background.fill(Paint.valueOf(CouleursJoueurs.couleursBackgroundJoueur.get(nouveau.getCouleur()))));
            }
            nbJetonsRailsRestants.textProperty().bind(nouveau.nbJetonsRailsProperty().asString());
            pointsRails.textProperty().bind(nouveau.pointsRailsProperty().asString());
            //Pour l'argent
            argent.textProperty().bind(nouveau.argentProperty().asString());
            argent.setOnMouseClicked(
                    mouseEvent -> {
                        GestionJeu.getJeu().joueurCourantProperty().get().recevoirArgentAEteChoisi();
                    }
            );
            //Pour le score
            score.textProperty().bind(nouveau.scoreProperty().asString());
            //Pour les points de rails
            pointsRails.textProperty().bind(nouveau.pointsRailsProperty().asString());
            //Pour la défausse
            deffausse.textProperty().bind(nouveau.defausseProperty().sizeProperty().asString());
            deffausse.setOnMouseClicked(
                    mouseEvent -> {
                        GestionJeu.getJeu().joueurCourantProperty().get().laDefausseAEteChoisie();
                    }
            );
            //Pour la pioche
            piocher.textProperty().bind(nouveau.piocheProperty().sizeProperty().asString());
            piocher.setOnMouseClicked(
                    mouseEvent -> {
                        GestionJeu.getJeu().joueurCourantProperty().get().laPiocheAEteChoisie();
                    }
            );
        });

        //Pour le bouton passer
        passer.setOnAction((ActionEvent event) -> {
                    GestionJeu.getJeu().passerAEteChoisi();
                }
        );

        passer.setStyle("-fx-background-color: transparent; -fx-border-width: 0; -fx-padding: 0;");
        gares.textProperty().bind(GestionJeu.getJeu().nbJetonsGare().asString());
    }

    public void creerStyle() {
        //TODO
    }

}