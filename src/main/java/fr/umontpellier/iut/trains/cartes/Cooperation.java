package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Cooperation extends Carte {
    public Cooperation() {
        super("Coopération", 5, 0, CouleurCarte.VERT);
    }

    @Override
    public void jouer(Joueur j) {
        j.setPointsRails(j.getPointsRails() + 1);
        if (Joueur.estEnJeu(j.getPassifsEnJeu(), Ferronnerie.class))
            j.setArgent(j.getArgent() + 2);
        if (!Joueur.estEnJeu(j.getPassifsEnJeu(), Depotoir.class)) {
            Carte c = j.getJeu().prendreDansLaReserve("Ferraille");
            if (c != null) {
                j.getCartesRecues().add(c);
            }
        }
        j.getPassifsEnJeu().add(this);
    }
}
