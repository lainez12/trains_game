package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.IJoueur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.io.IOException;

public class VueAutreJoueur extends VBox {
    @FXML
    private Label nomJoueur;
    @FXML
    private Label points;
    @FXML
    private Label rails;
    @FXML
    private Label piocher;
    @FXML
    private Label defausse;
    private IJoueur joueur;
    public VueAutreJoueur(IJoueur joueur) {
        this.joueur = joueur;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VueAutresJoueurs.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        creerBindings();
        setBackground(Background.fill(Paint.valueOf(CouleursJoueurs.couleursBackgroundJoueur.get(joueur.getCouleur()))));
    }

    public void  creerStyles(){
        //TODO
    }

    public void creerBindings() {
        nomJoueur.setText(joueur.getNom());
        rails.textProperty().bind(joueur.nbJetonsRailsProperty().asString());
        points.textProperty().bind(joueur.scoreProperty().asString());
        defausse.textProperty().bind(joueur.defausseProperty().sizeProperty().asString("%d"));
        piocher.textProperty().bind(joueur.piocheProperty().sizeProperty().asString("%d"));
    }

    public String getNomJoueur() {
        return nomJoueur.getText();
    }
}
