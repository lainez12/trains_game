package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;

import fr.umontpellier.iut.trains.Joueur;
import fr.umontpellier.iut.trains.plateau.Tuile;
import fr.umontpellier.iut.trains.plateau.TuileVille;

public class Gare extends Carte {
    public Gare() {
        super("Gare", 3, 0, CouleurCarte.VIOLET);
    }

    @Override
    public void jouer(Joueur j) {
        if (!Joueur.estEnJeu(j.getPassifsEnJeu(), Depotoir.class)) {
            Carte c = j.getJeu().prendreDansLaReserve("Ferraille");
            if (c != null) {
                j.getCartesRecues().add(c);
            }
        }
        if (j.getJeu().getNbJetonsGare() == 0) {
            j.choisir("Il n'y a plus de jetons gare, veuillez passer.", null, null, true);
        }
        ArrayList<String> choix = new ArrayList<>();
        Tuile t;
        for (int i = 0; i < j.getJeu().getTuiles().size(); i++) {
            t = j.getJeu().getTuile(i);
            if (t instanceof TuileVille) {
                if (t.getNbGares() < ((TuileVille) t).getNbGaresMax()) {
                    choix.add("TUILE:" + i);
                }
            }
        }
        if (choix.isEmpty()) {
            j.choisir("Il n'y a plus d'emplacement pour les gares, veuillez passer.", choix, null, true);
        } else {
            String res = j.choisir("Dans quelle ville voulez vous poser la gare ?", choix, null, false);
            int coord = Integer.parseInt(res.split(":")[1]);
            TuileVille c = (TuileVille) j.getJeu().getTuile(coord);
            c.setNbGaresPosees(c.getNbGares() + 1);
            j.getJeu().setNbJetonsGare(j.getJeu().getNbJetonsGare() - 1);
        }
    }
}
