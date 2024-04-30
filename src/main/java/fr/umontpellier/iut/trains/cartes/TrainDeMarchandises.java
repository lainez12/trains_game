package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class TrainDeMarchandises extends Carte {
    public TrainDeMarchandises() {
        super("Train de marchandises", 4, 1, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());

        String rep = " ";
        Set<String> choix = new HashSet<>();
        choix.add("Ferraille");

        while (!rep.equals("") && j.getMain().count("Ferraille") != 0) {
            rep = j.choisir("Voulez vous mettre la feraille de vore main dans la pile feraille", choix, null,
                    true);
            if (!rep.equals("")) {
                j.getJeu().getReserve().get("Ferraille").add(j.getMain().retirer("Ferraille"));
                j.setArgent(j.getArgent() + 1);
            }
        }
    }
}
