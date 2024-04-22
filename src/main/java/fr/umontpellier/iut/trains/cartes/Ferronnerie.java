package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Ferronnerie extends Carte {
    public Ferronnerie() {
        super("Ferronnerie", 4, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        j.getPassifsEnJeu().add(this);
    }
}
