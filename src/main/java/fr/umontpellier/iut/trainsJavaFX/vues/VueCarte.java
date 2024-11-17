package fr.umontpellier.iut.trainsJavaFX.vues;

import fr.umontpellier.iut.trainsJavaFX.mecanique.cartes.Carte;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * Cette classe représente la vue d'une carte.
 * <p>
 * On y définit le listener à exécuter lorsque cette carte a été choisie par l'utilisateur
 */
public class VueCarte extends StackPane {

    private final Carte carte;
    Image image;
    ImageView imageView;
    Label chiffrePourReserve;


    public String getNomCarteImage() {
        String nomCarte = carte.getNom().toLowerCase().replace(" ", "_") + ".jpg";
        nomCarte = nomCarte.replace("à", "a");
        nomCarte = nomCarte.replace("â", "a");
        nomCarte = nomCarte.replace("é", "e");
        nomCarte = nomCarte.replace("è", "e");
        nomCarte = nomCarte.replace("ë", "e");
        nomCarte = nomCarte.replace("ê", "e");
        nomCarte = nomCarte.replace("ô", "o");
        nomCarte = nomCarte.replace("ö", "o");
        nomCarte = nomCarte.replace("ü", "u");
        nomCarte = nomCarte.replace("ù", "u");
        nomCarte = nomCarte.replace("û", "u");
        nomCarte = nomCarte.replace("î", "i");
        nomCarte = nomCarte.replace("ï", "i");
        nomCarte = nomCarte.replace("ç", "c");
        return nomCarte;
    }
    public VueCarte(Carte carte) {
        this.carte = carte;

        Image image = new Image("/images/cartes/" + getNomCarteImage());
        imageView = new ImageView(image);
        imageView.setFitHeight(525*0.15); // ajustar el tamaño según sea necesario
        imageView.setFitWidth(375*0.15); // ajustar el tamaño según sea necesario
        this.getChildren().add(imageView);
        Tooltip tooltip = new Tooltip();
        ImageView tooltipImage = new ImageView(image);
        tooltipImage.setFitHeight(525 * 0.9); // Ajusta el tamaño según sea necesario
        tooltipImage.setFitWidth(375 * 0.9); // Ajusta el tamaño según sea necesario
        tooltip.setGraphic(tooltipImage);

        PauseTransition delay = new PauseTransition(Duration.seconds(0.8));
        delay.setOnFinished(event -> tooltip.show(this.getScene().getWindow()));

        // Muestra el Tooltip cuando el usuario coloca el cursor sobre la VueCarte
        this.setOnMouseEntered(event -> {
            delay.playFromStart();
        });

        // Oculta el Tooltip cuando el usuario retira el cursor de la VueCarte
        this.setOnMouseExited(event -> {
            delay.stop();
            tooltip.hide();
        });
    }

    public void setCarteChoisieListener(EventHandler<MouseEvent> quandCarteEstChoisie) {
        setOnMouseClicked(quandCarteEstChoisie);
    }

    public Carte getCarte() {
        return carte;
    }

    public void setStyles(){
           }

    public void cartesReserve(){
        chiffrePourReserve = new Label();
        chiffrePourReserve.setFont(new Font("Arial", 30));
        chiffrePourReserve.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-padding: 5px;");
        getChildren().add(chiffrePourReserve);
    }

    public void setTaille(double taille){
        imageView.setFitHeight(525*taille); // ajustar el tamaño según sea necesario
        imageView.setFitWidth(375*taille); // ajustar el tamaño según sea necesario
    }

    public void setChifre(int chifre){
         chiffrePourReserve.setText(String.valueOf(chifre));
    }
}