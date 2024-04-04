package fr.umontpellier.iut.trains.cartes;

/**
 * CouleurCarte
 */
public enum CouleurCarte {
    JAUNE, ROUGE, VERT, BLEU, VIOLET, GRIS;

    @Override
    public String toString() {
        return switch (this) {
            case JAUNE -> "vitoire";
            case ROUGE -> "action";
            case VERT -> "rail";
            case BLEU -> "train";
            case GRIS -> "ferraille";
            case VIOLET -> "gare";
        };
    }
}