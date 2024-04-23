package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Ferraille extends Carte {
    public Ferraille() {
        super("Ferraille", 0, 0, CouleurCarte.GRIS);
    }

    @Override
    public void jouer(Joueur j) {
        if (j.getCartesEnJeu().size() == 1) {
            j.getJeu().getReserve().get(getNom()).add(j.getCartesEnJeu().retirer(getNom()));
            j.getPassifsEnJeu().add(this);
            int temp = j.getMain().count(getNom());
            for (int i = 0; i < temp; i++) {
                j.getJeu().getReserve().get(getNom()).add(j.getMain().retirer(getNom()));
            }
        } else {
            j.getMain().add(j.getCartesEnJeu().retirer(getNom()));
        }
    }

}
