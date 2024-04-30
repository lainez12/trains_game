package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;

import fr.umontpellier.iut.trains.Joueur;

public class CabineDuConducteur extends Carte {
    public CabineDuConducteur() {
        super("Cabine du conducteur", 2, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Carte c;
        ArrayList<String> choix = new ArrayList<>();
        ArrayList<Carte> res = new ArrayList<>();
        String rep = " ";
        for (Carte i : j.getMain()) {
            choix.add(i.getNom());
        }
        while (!choix.isEmpty() && !rep.equals("")) {
            rep = j.choisir("Choisissez une carte à défausser", choix, null, true);
            if (rep != "") {
                j.getDefausse().add(j.getMain().retirer(rep));
                j.log("Un/Une " + rep + " a été défaussé(e)");
                c = j.piocher();
                if (c != null) {
                    res.add(c);
                }
            }
        }
        for (Carte carte : res) {
            j.getMain().add(carte);
        }
    }
}
