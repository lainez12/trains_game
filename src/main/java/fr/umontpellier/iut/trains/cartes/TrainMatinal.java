package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class TrainMatinal extends Carte {
    public TrainMatinal() {
        super("Train matinal", 5, 2, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        j.getCartesEnJeu().add(this);
    }
}
