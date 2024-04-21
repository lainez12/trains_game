package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class PoseDeRails extends Carte {
    public PoseDeRails() {
        super("Pose de rails", 3, 0, CouleurCarte.VERT);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        joueur.setPointsRails(joueur.getPointsRails() + 1);
        joueur.getCartesRecues().add(joueur.getJeu().prendreDansLaReserve("Ferraille"));
    }
}
