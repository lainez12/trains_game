package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class HorairesEstivaux extends Carte {
    public HorairesEstivaux() {
        super("Horaires estivaux", 3, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        String rep = " ";
        Set<String> choix = new HashSet<>();
        choix.add("oui");
        choix.add("non");
        rep = joueur.choisir("Voulez vous ecarter cette carte pour gagner 3 d'argent? oui ou non", choix, null, false);
        if (rep.equals("oui")) {
            joueur.setArgent(joueur.getArgent() + 3);
            joueur.getJeu().getCartesEcartees().add(joueur.getCartesEnJeu().retirer("Horaires estivaux"));
        }
    }
}
