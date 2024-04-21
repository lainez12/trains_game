package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class PersonnelDeGare extends Carte {
    public PersonnelDeGare() {
        super("Personnel de gare", 2, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Set<String> choix = new HashSet<>();
        choix.add("piocher");
        choix.add("argent");
        choix.add("ferraille");

        String rep = j.choisir(
                "Choisisser entre piocher une carte, gagner 1 d'argent ou remettre 1 de feraille de votre main sur la pile ferraille.",
                choix, null, false);

        if (rep.equals("piocher")) {
            Carte temp = j.piocher();
            if (temp != null) {
                j.getMain().add(temp);
            }
        } else if (rep.equals("argent")) {
            j.setArgent(j.getArgent() + 1);
        } else if (rep.equals("ferraille")) {
            if (j.getMain().count("Ferraille") != 0) {
                j.getJeu().getReserve().get("Ferraille").add(j.getMain().retirer("Ferraille"));
            }
        }
    }
}
