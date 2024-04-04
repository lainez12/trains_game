package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Aiguillage extends Carte {
    public Aiguillage() {
        super("Aiguillage", 5, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        j.piocher(2);
    }
}
