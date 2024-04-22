package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Depotoir extends Carte {
    public Depotoir() {
        super("Dépotoir", 5, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        j.getPassifsEnJeu().add(this);
    }
}
