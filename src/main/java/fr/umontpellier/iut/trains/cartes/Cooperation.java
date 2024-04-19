package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Cooperation extends Carte {
    public Cooperation() {
        super("Coopération", 5, 0, CouleurCarte.VERT);
    }

    @Override
    public void jouer(Joueur j) {
        j.setPointsRails(j.getPointsRails() + 1);
        Carte c = j.getJeu().prendreDansLaReserve("Feraille");
        if (c != null) {
            j.getMain().add(c);
        }
        j.setPassifCoop(true);
    }
}
