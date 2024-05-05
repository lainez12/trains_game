package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Bouton;
import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
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
        ArrayList<Bouton> boutons = new ArrayList<>();
        boutons.add(new Bouton("oui"));
        boutons.add(new Bouton("non"));
        rep = joueur.choisir("Voulez vous ecarter cette carte pour gagner 3 d'argent? oui ou non", choix, boutons,
                false);
        if (rep.equals("oui")) {
            joueur.setArgent(joueur.getArgent() + 3);
            joueur.getJeu().getCartesEcartees().add(joueur.getCartesEnJeu().retirer("Horaires estivaux"));
        }
    }
}
