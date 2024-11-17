package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.GestionJeu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class Intructions extends HBox {

    @FXML
    private Text nom;
    @FXML
    private TextFlow textFlowInstru;
    @FXML
    private Text instructions;
    public Intructions() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/instructions.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creeBindings() {
        GestionJeu.getJeu().joueurCourantProperty().addListener((observable, vieux, nouveau) -> {
            nom.setText(nouveau.getNom());
            //setBackground(Background.fill(Paint.valueOf(CouleursJoueurs.couleursBackgroundJoueur.get(nouveau.getCouleur()))));
            setBorder(new Border(new BorderStroke(Paint.valueOf(CouleursJoueurs.couleursBackgroundJoueur.get(nouveau.getCouleur())), BorderStrokeStyle.SOLID, new CornerRadii(15), new BorderWidths(8))));
            nom.setFill(Paint.valueOf(CouleursJoueurs.couleursBackgroundJoueur.get(nouveau.getCouleur())));
        });
        instructions.textProperty().bind(GestionJeu.getJeu().instructionProperty());
    }
}
