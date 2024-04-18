package fr.umontpellier.iut.trains.plateau;

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
    public int getSurcout() {
        return 1 + nbGaresMax + super.getSurcout();
    }

}
