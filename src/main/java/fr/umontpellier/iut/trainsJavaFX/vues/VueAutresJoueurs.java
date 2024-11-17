package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.GestionJeu;
import fr.umontpellier.iut.trainsJavaFX.IJoueur;
import fr.umontpellier.iut.trainsJavaFX.mecanique.Joueur;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe présente les éléments des joueurs autres que le joueur courant,
 * en cachant ceux que le joueur courant n'a pas à connaitre.
 * <p>
 * On y définit les bindings sur le joueur courant, ainsi que le listener à exécuter lorsque ce joueur change
 */
public class VueAutresJoueurs extends VBox {
    private VueAutreJoueur joueurCourant;
    private List<VueAutreJoueur> joueursVues;

    public VueAutresJoueurs(List<? extends IJoueur> joueurs) {
        joueursVues = new ArrayList<>();
        for (IJoueur joueur : joueurs) {
            VueAutreJoueur v = new VueAutreJoueur(joueur);
            joueursVues.add(v);
        }
    }

    public void creerBindings() {
        for (VueAutreJoueur v : joueursVues) {
            if (v.getNomJoueur().equals(GestionJeu.getJeu().joueurCourantProperty().get().getNom())) {
                joueurCourant = v;
            } else {
                this.getChildren().add(v);
            }
        }
    }

    public  void changeJoueurCourant(IJoueur effacer){
        for (Node j : this.getChildren()) {
            VueAutreJoueur v = (VueAutreJoueur) j;
            if(v.getNomJoueur().equals(effacer.getNom())){
                this.getChildren().remove(j);
                this.getChildren().add(joueurCourant);
                joueurCourant = (VueAutreJoueur) j;
                break;
            }
        }
    }

}
