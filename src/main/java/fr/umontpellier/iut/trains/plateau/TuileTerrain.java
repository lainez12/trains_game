package fr.umontpellier.iut.trains.plateau;

/**
 * Classe représentant une tuile plaine, fleuve ou montagne.
 */
public class TuileTerrain extends Tuile {
    /**
     * Type de terrain de la tuile ({@code PLAINE}, {@code FLEUVE} ou
     * {@code MONTAGNE})
     */
    private TypeTerrain type;

    public TuileTerrain(TypeTerrain type) {
        super();
        this.type = type;
    }

    @Override
    public int getSurcout() {
        switch (type) {
            case FLEUVE:
                return 1 + super.getSurcout();
            case MONTAGNE:
                return 2 + super.getSurcout();
            default:
                return super.getSurcout();
        }
    }
}
