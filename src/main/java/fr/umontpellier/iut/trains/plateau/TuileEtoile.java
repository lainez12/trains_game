package fr.umontpellier.iut.trains.plateau;

import fr.umontpellier.iut.trains.Joueur;
import fr.umontpellier.iut.trains.cartes.ListeDeCartes;
import fr.umontpellier.iut.trains.cartes.VoieSouterraine;

/**
 * Classe représentant une tuile étoile (lieu éloigné)
 */
public class TuileEtoile extends Tuile {
    /**
     * Valeur du lieu éloigné (valeur indiquée sur le plateau)
     */
    private int valeur;

    public TuileEtoile(int valeur) {
        super();
        this.valeur = valeur;
    }

    @Override
    public int getPoints() {
        return valeur;
    }

    @Override
    public int getSurcout(ListeDeCartes l) {
        if (Joueur.estEnJeu(l, VoieSouterraine.class))
            return 0;
        return valeur + super.getSurcout(l);
    }
}
