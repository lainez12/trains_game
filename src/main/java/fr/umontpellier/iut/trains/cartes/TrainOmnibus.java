package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class TrainOmnibus extends Carte {
    public TrainOmnibus() {
        super("Train omnibus", 1, 1, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        joueur.setArgent(joueur.getArgent() + 1);
    }
}
