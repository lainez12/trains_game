package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Decharge extends Carte {
    public Decharge() {
        super("Décharge", 2, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        int temp = j.getMain().count("Ferraille");
        for (int i = 0; i < temp; i++) {
            j.getJeu().getReserve().get("Ferraille").add(j.getMain().retirer("Ferraille"));
        }
    }
}
