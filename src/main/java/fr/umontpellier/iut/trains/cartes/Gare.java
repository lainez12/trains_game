package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;

import fr.umontpellier.iut.trains.Joueur;
import fr.umontpellier.iut.trains.plateau.Tuile;
import fr.umontpellier.iut.trains.plateau.TuileVille;

public class Gare extends Carte {
    public Gare() {
        super("Gare", 3, 0, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur j) {
        if (!Joueur.estEnJeu(j.getCartesEnJeu(), Depotoir.class)) {
            Carte c = j.getJeu().prendreDansLaReserve("Ferraille");
            if (c != null) {
                j.getMain().add(c);
            }
        }
        ArrayList<String> choix = new ArrayList<>();
        Tuile t;
        for (int i = 0; i < j.getJeu().getTuiles().size(); i++) {
            t = j.getJeu().getTuile(i);
            if (t instanceof TuileVille) {
                if (t.getNbGares() == ((TuileVille) t).getNbGaresMax()) {
                    choix.add("TUILE:" + i);
                }
            }
        }
        if (choix.isEmpty()) {
            j.choisir("Il n'y a plus d'emplacement pour les gares, veillez passer.", choix, null, true);
        } else {
            String res = j.choisir("Dans quelle ville voulez vous poser la gare ?", choix, null, false);
            int coord = Integer.parseInt(res.split(":")[1]);
            TuileVille c = (TuileVille) j.getJeu().getTuile(coord);
            c.setNbGaresPosees(c.getNbGares() + 1);
        }
    }
}
