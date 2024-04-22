package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public abstract class Carte {
    private final String nom;
    private final int cout;
    private final int valeur;
    private final CouleurCarte couleur;

    /**
     * Constructeur simple
     * <p>
     * Important : La classe Carte est actuellement très incomplète. Vous devrez
     * ajouter des attributs et des méthodes et donc probablement définir au moins
     * un autre constructeur plus complet. Les sous-classes de Cartes qui vous sont
     * fournies font appel à ce constructeur simple mais au fur et à mesure que vous
     * les compléterez, elles devront utiliser les autres constructeurs de Carte. Si
     * vous n'utilisez plus ce constructeur, vous pouvez le supprimer.
     * 
     * @param nom
     */
    public Carte(String nom, int cout, int valeur, CouleurCarte couleur) {
        this.nom = nom;
        this.cout = cout;
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public int getCout() {
        return cout;
    }

    public int getValeur() {
        return valeur;
    }

    public CouleurCarte getCouleur() {
        return couleur;
    }

    public int getPoints() {
        return 0;
    }

    /**
     * Cette fonction est exécutée lorsqu'un joueur joue la carte pendant son tour.
     * Toutes les cartes ont une méthode jouer, mais elle ne fait rien par défaut.
     * 
     * @param joueur le joueur qui joue la carte
     */
    public void jouer(Joueur joueur) {
    }

    @Override
    public String toString() {
        return nom + " :\nCoût : " + cout + "\nValeur : " + valeur + "\nType : " + couleur;
    }

}
