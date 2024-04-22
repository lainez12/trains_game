package fr.umontpellier.iut.trains.plateau;

import fr.umontpellier.iut.trains.Joueur;
import fr.umontpellier.iut.trains.cartes.ListeDeCartes;
import fr.umontpellier.iut.trains.cartes.Viaduc;
import fr.umontpellier.iut.trains.cartes.VoieSouterraine;

/**
 * Classe représentant une tuile ville (où l'on peut poser des gares)
 */
public class TuileVille extends Tuile {
    /**
     * Nombre maximum de gares que l'on peut poser sur la tuile
     */
    private int nbGaresMax;
    /**
     * Nombre de gares posées sur la tuile
     */
    private int nbGaresPosees;

    public TuileVille(int taille) {
        super();
        this.nbGaresMax = taille;
        this.nbGaresPosees = 0;
    }

    @Override
    public int getPoints() {
        switch (nbGaresPosees) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    @Override
    public int getSurcout(ListeDeCartes l) {
        if (Joueur.estEnJeu(l, Viaduc.class) || Joueur.estEnJeu(l, VoieSouterraine.class))
            return 0;
        return 1 + nbGaresPosees + super.getSurcout(l);
    }

    public int getNbGaresMax() {
        return nbGaresMax;
    }

    @Override
    public int getNbGares() {
        return nbGaresPosees;
    }

    public void setNbGaresPosees(int nbGaresPosees) {
        this.nbGaresPosees = nbGaresPosees;
    }

}
