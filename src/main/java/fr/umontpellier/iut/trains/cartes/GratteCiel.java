package fr.umontpellier.iut.trains.cartes;

public class GratteCiel extends Carte {
    public GratteCiel() {
        super("Gratte-Ciel", 8, 0, CouleurCarte.JAUNE);
    }

    @Override
    public int getPoints() {
        return 4;
    }
}