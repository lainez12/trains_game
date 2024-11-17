package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.mecanique.plateau.Plateau;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControleurChoixJoueursFxml extends Pane {
    @FXML
    private ComboBox<Integer> cmbNBJoueurs;

    @FXML
    private ComboBox<String> cmbPlateau;

    @FXML
    private VBox mainNoms;

    @FXML
    private Button btnStart;

    private ObservableList<TextField> textFields;

    private ObservableList<String> nomsJoueurs;
    private BooleanProperty joueurD;
    private StringProperty plateauChoisi;

    public ControleurChoixJoueursFxml(ObservableList<String> nomsJoueurs, BooleanProperty joueurDefinis, StringProperty plateauChoisi) {
        this.nomsJoueurs = nomsJoueurs;
        this.joueurD = joueurDefinis;
        this.plateauChoisi = plateauChoisi;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VueChoixJoueurs.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cmbNBJoueurs.getItems().addAll(2,3,4);
        cmbPlateau.getItems().addAll("OSAKA", "TOKYO");
        mainNoms.setAlignment(Pos.CENTER);
        btnStart.setDisable(true);
        createBiding();
    }

    public void createBiding() {
        plateauChoisi.bind(cmbPlateau.valueProperty());
        cmbNBJoueurs.setOnAction(actionEvent -> {
            textFields = FXCollections.observableArrayList();
            mainNoms.getChildren().clear();
            for (int i = 0; i < cmbNBJoueurs.getValue(); i++) {
                HBox joueur = new HBox();
                TextField joueurText = new TextField();
                Label joueurLabel = new Label("Joueur " + (i + 1));
                joueurLabel.setTextFill(Paint.valueOf("white"));
                textFields.add(joueurText);
                joueur.getChildren().addAll(joueurLabel, joueurText);
                mainNoms.getChildren().add(joueur);
                joueurText.textProperty().addListener((observable, oldValue, newValue) -> {
                    boolean allFilled = textFields.stream().allMatch(tf -> !tf.getText().isEmpty()) &&
                            textFields.stream().allMatch(tf -> !tf.getText().isBlank())
                            && !textFieldsDupliques();
                    btnStart.setDisable(!allFilled);
                });
            }
        });
        btnStart.setOnAction(actionEvent -> {
            for (TextField tf : textFields) {
                nomsJoueurs.add(tf.getText());
            }
            joueurD.set(true);
        });
    }

    public boolean textFieldsDupliques() {
        return textFields.stream()
                .collect(Collectors.groupingBy(tf -> tf.getText().trim(), Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count > 1);
    }

    public List<TextField> getMainNoms() {
        return textFields;
    }
}

