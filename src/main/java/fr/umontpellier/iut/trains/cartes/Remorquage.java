package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class Remorquage extends Carte {
    public Remorquage() {
        super("Remorquage", 3, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Set<String> choix = new HashSet<>();
        String rep = "";
        for (Carte c : j.getDefausse()) {
            if (c.getCouleur() == CouleurCarte.BLEU) {
                choix.add(c.getNom());
            }
        }
        if (choix.isEmpty()) {
            rep = j.choisir("Vous devez passer car vous n'avez pas de carte train dans votre defausse.", choix,
                    null, true);
        } else {
            rep = j.choisir("Choisissez une carte Train de votre défausse pour l'ajouter à votre main.", choix, null,
                    false);
            j.getMain().add(j.getDefausse().retirer(rep));
        }
    }
}
