package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class TrainDeTourisme extends Carte {
    public TrainDeTourisme() {
        super("Train de tourisme", 4, 1, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        joueur.setArgent(joueur.getArgent() + 1);
        joueur.setScore(joueur.getScore() + 1);
    }
}
