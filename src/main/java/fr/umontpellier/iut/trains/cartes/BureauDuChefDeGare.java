package fr.umontpellier.iut.trains.cartes;

import java.util.HashSet;
import java.util.Set;

import fr.umontpellier.iut.trains.Joueur;

public class BureauDuChefDeGare extends Carte {
    public BureauDuChefDeGare() {
        super("Bureau du chef de gare", 4, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Set<String> choix = new HashSet<>();
        String res = "";
        for (Carte i : j.getMain()) {
            if (i.getCouleur() == CouleurCarte.ROUGE && !i.getNom().equals("Bureau du chef de gare")) {
                choix.add(i.getNom());
            }
        }
        if (choix.isEmpty()) {
            j.choisir("Vous n'avez pas de carte ACTION en main", choix, null, true);
        } else {
            res = j.choisir("Choisissez une carte ACTION de votre main à révéler", choix, null, false);
            j.setArgent(j.getArgent() - j.getMain().getCarte(res).getValeur());
            j.getMain().getCarte(res).jouer(j);
        }
    }
}
