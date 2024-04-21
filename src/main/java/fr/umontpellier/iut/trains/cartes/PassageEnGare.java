package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class PassageEnGare extends Carte {
    public PassageEnGare() {
        super("Passage en gare", 3, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Carte temp = j.piocher();
        if (temp != null) {
            j.getMain().add(temp);
        }
        j.setArgent(j.getArgent() + getValeur());
    }
}
