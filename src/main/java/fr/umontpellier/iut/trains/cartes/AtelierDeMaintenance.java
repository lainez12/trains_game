package fr.umontpellier.iut.trains.cartes;

import java.util.Set;
import java.util.HashSet;

import fr.umontpellier.iut.trains.Joueur;

public class AtelierDeMaintenance extends Carte {
    public AtelierDeMaintenance() {
        super("Atelier de maintenance", 5, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Set<String> choix = new HashSet<>();
        String res = "";
        for (Carte i : j.getMain()) {
            if (i.getCouleur() == CouleurCarte.BLEU) {
                choix.add(i.getNom());
            }
        }
        if (choix.isEmpty()) {
            System.out.println("Vous n'avez pas de carte train en main");
        } else {
            res = j.choisir("Choisissez une carte Train de votre main à révéler", choix, null, false);
        }
        Carte c = j.getJeu().prendreDansLaReserve(res);
        if (c != null) {
            j.getCartesRecues().add(c);
        }
    }
}
