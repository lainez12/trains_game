package fr.umontpellier.iut.trains.cartes;

public class Aiguillage extends Carte {
    public Aiguillage() {
        super("Aiguillage", 5, 0, CouleurCarte.ROUGE);
    }

    public int getPrix() {
        return 5;
    }
}
