package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class TrainPostal extends Carte {
    public TrainPostal() {
        super("Train postal", 4, 1, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());

        String rep = " ";
        Set<String> choix = new HashSet<>();
        for (Carte i : j.getMain()) {
            choix.add(i.getNom());
        }

        while (!rep.equals("") && !j.getMain().isEmpty()) {
            rep = j.choisir(
                    "Défausser autant de carte que vous le voulez pour gagner 1 d'argent par carte defaussée.", choix,
                    null, true);
            if (!rep.equals("")) {
                j.getDefausse().add(j.getMain().retirer(rep));
                j.setArgent(j.getArgent() + 1);
                choix.remove(rep);
            }
        }
    }
}
