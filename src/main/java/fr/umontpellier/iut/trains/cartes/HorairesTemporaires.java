package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;

import fr.umontpellier.iut.trains.Joueur;

public class HorairesTemporaires extends Carte {
    public HorairesTemporaires() {
        super("Horaires temporaires", 5, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        int count = 0;
        ArrayList<Carte> l = new ArrayList<>();
        Carte c;
        while (count != 2) {
            c = j.piocher();
            if (c != null) {
                if (c.getCouleur() == CouleurCarte.BLEU) {
                    j.getMain().add(c);
                    count++;
                } else {
                    l.add(c);
                }
            } else {
                break;
            }
        }
        j.getDefausse().addAll(l);
    }
}
