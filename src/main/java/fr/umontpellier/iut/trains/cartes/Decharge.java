package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Decharge extends Carte {
    public Decharge() {
        super("Décharge", 2, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        for (int i = 0; i < j.getMain().count("Ferraille"); i++) {
            j.getDefausse().add(j.getMain().retirer("Ferraille"));
        }
    }
}
