package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class TGV extends Carte {
    public TGV() {
        super("TGV", 2, 1, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        joueur.setArgent(joueur.getArgent() + 1);
        TrainOmnibus t = new TrainOmnibus();
        for (int i = 0; i < joueur.getCartesEnJeu().size(); i++) {
            if (joueur.getCartesEnJeu().get(i).equals(t)){
                joueur.setArgent(joueur.getArgent() + 1);
                break;
            }
        }
    }
}
