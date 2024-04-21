package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;
import java.util.List;

import fr.umontpellier.iut.trains.Joueur;

public class ParcDAttractions extends Carte {
    public ParcDAttractions() {
        super("Parc d'attractions", 4, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        List<String> l = new ArrayList<>();
        String rep;
        for (Carte c : j.getCartesEnJeu()) {
            if (c.getCouleur() == CouleurCarte.BLEU) {
                l.add(c.getNom());
            }
        }
        if (l.isEmpty()) {
            rep = j.choisir("Vous devez passer car vous n'avez pas de carte train dans vos cartes en jeu.", l,
                    null, true);
        } else {
            rep = j.choisir("Choissez l'une de vos cartes train en jeu afin de récuperer sa valeur.", l, null, false);
            j.setArgent(j.getArgent() + j.getCartesEnJeu().getCarte(rep).getValeur());
        }
    }

}
