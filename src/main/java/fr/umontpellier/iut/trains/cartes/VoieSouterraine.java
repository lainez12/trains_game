package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Jeu;
import fr.umontpellier.iut.trains.Joueur;

public class VoieSouterraine extends Carte {
    public VoieSouterraine() {
        super("Voie souterraine", 7,0,CouleurCarte.VERT);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        joueur.setPointsRails(joueur.getPointsRails() + 1);
        joueur.getCartesRecues().add(joueur.getJeu().prendreDansLaReserve("Ferraille"));


    }
}
