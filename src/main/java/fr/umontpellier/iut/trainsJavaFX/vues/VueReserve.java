package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.GestionJeu;
import fr.umontpellier.iut.trainsJavaFX.mecanique.cartes.Carte;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class VueReserve extends FlowPane {

    public VueReserve() {
        setAlignment(Pos.CENTER_RIGHT);
        setHgap(20);
        setVgap(10);
    }
    public void ajouterCartesReserve() {
        //int x = 0, y = 0;
        for (Carte c : GestionJeu.getJeu().getReserve()) {
            VueCarte b = new VueCarte(c);
            b.cartesReserve();
            b.setTaille(0.30);
            b.setOnMouseClicked(
                    mouseEvent -> {
                        GestionJeu.getJeu().uneCarteDeLaReserveEstAchetee(b.getCarte().getNom());
                    }
            );
            /*b.setOnMouseClicked(actionAchatReserve);
            b.setMaxWidth(joueurCourant_Reserve.prefWidthProperty().divide(4).get());
            this.add(b, x, y);
            if (y == 3) {
                y = 0;
                x++;
            }else y++;*/
            getChildren().add(b);
            this.prefWrapLengthProperty().bind(this.widthProperty());
            IntegerProperty i = GestionJeu.getJeu().getTaillesPilesReserveProperties().get(c.getNom());
            b.setChifre(i.get());
            i.addListener((observable, oldValue, newValue) -> {
                b.setChifre(newValue.intValue());
            });
        }
    }

}
