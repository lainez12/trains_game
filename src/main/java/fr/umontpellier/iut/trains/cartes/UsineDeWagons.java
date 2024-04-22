package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;

import fr.umontpellier.iut.trains.Joueur;

public class UsineDeWagons extends Carte {
    public UsineDeWagons() {
        super("Usine de wagons", 5, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        ArrayList<String> choix = new ArrayList<>();
        for (Carte c : j.getMain()) {
            if (c.getCouleur() == CouleurCarte.BLEU) {
                choix.add(c.getNom());
            }
        }
        if (choix.isEmpty()) {
            j.choisir("Vous n'avez pas de carte train en main, veuillez passer.", choix, null, true);
        } else {
            String res = j.choisir("Choisissez la carte train que vous souhaitez écarter.", choix, null, false);
            Carte c = j.getMain().retirer(res);
            ArrayList<String> choix2 = new ArrayList<>();
            for (String s : j.getJeu().getReserve().keySet()) {
                if (!j.getJeu().getReserve().get(s).isEmpty()) {
                    if (j.getJeu().getReserve().get(s).get(0).getCouleur() == CouleurCarte.BLEU) {
                        if (j.getJeu().getReserve().get(s).get(0).getCout() <= c.getCout() + 3) {
                            choix2.add("ACHAT:" + s);
                        }
                    }
                }
            }
            j.getJeu().getCartesEcartees().add(c);
            if (choix2.isEmpty()) {
                j.choisir("Il n'y a pas de carte train valide dans la réserve, veuillez passer.", choix2, null, true);
            } else {
                res = j.choisir("Choisissez la carte train que vous souhaitez récupérer.", choix2, null, false);
                j.getMain().add(j.getJeu().prendreDansLaReserve(res.split(":")[1]));
            }
        }
    }
}
