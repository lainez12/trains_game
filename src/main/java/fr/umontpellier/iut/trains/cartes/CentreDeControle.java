package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;

import fr.umontpellier.iut.trains.Joueur;

public class CentreDeControle extends Carte {
    public CentreDeControle() {
        super("Centre de contrôle", 3, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Carte c = j.piocher();
        if (c != null) {
            j.getMain().add(c);
            ArrayList<String> choix = new ArrayList<>();
            for (String nom : j.getJeu().getReserve().keySet()) {
                choix.add(nom);
            }
            choix.add("Train omnibus");
            String s = j.choisir("Nommez la prochaine carte de votre deck : ", choix, null, false);
            if (j.getPioche().get(0).getNom().equals(s)) {
                j.getMain().add(j.piocher());
            }
        }
    }
}
