package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.List;

public class Aiguillage extends Carte {
    public Aiguillage() {
        super("Aiguillage", 5, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        List<Carte> cartePioche = new ListeDeCartes();
        cartePioche = j.piocher(2);
        for (Carte c : cartePioche) {
            j.getMain().add(c);
        }
    }
}
