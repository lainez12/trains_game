package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class TrainExpress extends Carte {
    public TrainExpress() {
        super("Train express", 3, 2, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
    }
}
