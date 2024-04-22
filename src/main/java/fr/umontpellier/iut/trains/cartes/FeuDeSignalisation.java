package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;

import fr.umontpellier.iut.trains.Joueur;

public class FeuDeSignalisation extends Carte {
    public FeuDeSignalisation() {
        super("Feu de signalisation", 2, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Carte c = j.piocher();
        if (c != null) {
            j.getMain().add(c);
            c = j.piocher();
            if (c != null) {
                j.log("Vous tirez : " + c.getNom());
                ArrayList<String> choix = new ArrayList<>();
                choix.add("oui");
                choix.add("non");
                String res = j.choisir("Voulez la defausser 'oui' ou la replacer 'non' sur votre deck ?", choix, null,
                        false);
                if (res == "oui") {
                    j.getDefausse().add(c);
                } else {
                    j.getPioche().add(0, c);
                }
            }
        }
    }
}
