package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;

import fr.umontpellier.iut.trains.Joueur;

public class Echangeur extends Carte {
    public Echangeur() {
        super("Échangeur", 3, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        ArrayList<String> choix = new ArrayList<>();
        for (Carte c : j.getCartesEnJeu()) {
            if (c.getCouleur() == CouleurCarte.BLEU) {
                choix.add(c.getNom());
            }
        }
        if (choix.isEmpty()) {
            j.choisir("Vous n'avez pas de carte train en jeu, veuillez passer.", choix, null, true);
        } else {
            String res = j.choisir("Choisissez une de vos cartes train à mettre sur votre pioche.(vous pouvez passer)",
                    choix, null, true);
            j.getPioche().add(0, j.getCartesEnJeu().retirer(res));
            if (res.equals("Train matinal"))
                j.getPassifsEnJeu().retirer(res);
        }
    }
}
