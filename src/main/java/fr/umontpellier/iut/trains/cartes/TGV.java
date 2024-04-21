package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class TGV extends Carte {
    public TGV() {
        super("TGV", 2, 1, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        if (Joueur.estEnJeu(j.getCartesEnJeu(), TrainOmnibus.class))
            j.setArgent(j.getArgent() + 1);
    }
}
