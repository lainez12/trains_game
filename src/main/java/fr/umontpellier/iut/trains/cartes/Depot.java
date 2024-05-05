package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;
import java.util.List;

import fr.umontpellier.iut.trains.Joueur;

public class Depot extends Carte {
    public Depot() {
        super("Dépôt", 3, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        List<Carte> cartePioche = j.piocher(2);
        for (Carte c : cartePioche) {
            j.getMain().add(c);
        }
        int temp;
        if (j.getMain().size() < 2)
            temp = j.getMain().size();
        else
            temp = 2;
        for (int i = 0; i < temp; i++) {
            List<String> l = new ArrayList<>();
            for (Carte c : j.getMain()) {
                l.add(c.getNom());
            }
            j.getDefausse().add(
                    j.getMain().retirer(j.choisir("Choisissez une carte de votre main à défausser.", l, null, false)));
        }

    }
}
