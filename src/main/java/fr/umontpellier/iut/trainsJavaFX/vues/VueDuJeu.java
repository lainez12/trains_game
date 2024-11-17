package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.GestionJeu;
import fr.umontpellier.iut.trainsJavaFX.IJeu;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

/**
 * Cette classe correspond à la fenêtre principale de l'application.
 *
 * Elle est initialisée avec une référence sur la partie en cours (Jeu).
 * <p>
 * On y définit les bindings sur les éléments internes qui peuvent changer
 * (le joueur courant, ses cartes en main, son score, ...)
 * ainsi que les listeners à exécuter lorsque ces éléments changent
 */
public class VueDuJeu extends VBox {

    private final IJeu jeu;
    private ScrollPane scrollPaneReserve;
    private VuePlateau plateau;
    private VueReserve vueReserve;
    private VueAutresJoueurs vueAutresJoueurs;
    private VueJoueurCourant vueJoueurCourant;
    private Intructions header;
    private HBox centre;
    public VueDuJeu(IJeu jeu) {
        this.jeu = jeu;
        plateau = new VuePlateau();
        vueReserve = new VueReserve();
        header = new Intructions();

        centre = new HBox();
        vueJoueurCourant = new VueJoueurCourant();
        scrollPaneReserve= new ScrollPane(vueReserve);
        vueAutresJoueurs = new VueAutresJoueurs(jeu.getJoueurs());
        centre.getChildren().addAll(vueAutresJoueurs,plateau,scrollPaneReserve);
        getChildren().addAll(header,centre,vueJoueurCourant);
        setSyles();
    }

    public void creerBindings() {
        //plateau.prefWidthProperty().bind(getScene().widthProperty());
        //plateau.prefHeightProperty().bind(getScene().heightProperty());
        plateau.creerBindings();
        vueAutresJoueurs.prefWidthProperty().bind(getScene().widthProperty().multiply(DonneesGraphiques.autresJoueursWidth));
        scrollPaneReserve.prefWidthProperty().bind(getScene().widthProperty().multiply(DonneesGraphiques.reserveWidth));
        scrollPaneReserve.prefHeightProperty().bind(plateau.heightProperty());
        vueReserve.prefWidthProperty().bind(scrollPaneReserve.widthProperty().subtract(50));
        header.prefWidthProperty().bind(getScene().widthProperty());
        bindingsJoueurCourren();
        vueReserve.ajouterCartesReserve();
        vueAutresJoueurs.creerBindings();
        header.creeBindings();
        vueJoueurCourant.creerBindings();
        vueJoueurCourant.prefWidthProperty().bind(getScene().widthProperty());
        //vueJoueurCourant.prefHeightProperty().bind(getScene().heightProperty().multiply(DonneesGraphiques.joueurCourantHeight));
        VBox.setVgrow(vueJoueurCourant, Priority.ALWAYS);
    }

    public void bindingsJoueurCourren(){
        getJeu().joueurCourantProperty().addListener((observable, oldValue, newValue) -> vueAutresJoueurs.changeJoueurCourant(jeu.joueurCourantProperty().get()));
    }

    public void setSyles(){
        header.setMaxHeight(80);
        centre.setAlignment(Pos.TOP_CENTER);
    }

    public IJeu getJeu() {
        return jeu;
    }

    EventHandler<? super MouseEvent> actionPasserParDefaut = (mouseEvent -> System.out.println("Passer a été demandé"));

}
