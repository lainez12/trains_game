package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class PoseDeRails extends Carte {
    public PoseDeRails() {
        super("Pose de rails", 3, 0, CouleurCarte.VERT);
    }

    @Override
    public void jouer(Joueur j) {
        j.setPointsRails(j.getPointsRails() + 1);
        if (!Joueur.estEnJeu(j.getCartesEnJeu(), Depotoir.class)) {
            Carte c = j.getJeu().prendreDansLaReserve("Ferraille");
            if (c != null) {
                j.getCartesRecues().add(c);
            }
        }
    }
}
