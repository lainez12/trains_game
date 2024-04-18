package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class CentreDeControle extends Carte {
    public CentreDeControle() {
        super("Centre de contrôle", 3, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        Carte c = j.piocher();
        if (c != null) {
            j.getMain().add(c);
            j.log("Nommez la prochaine carte de votre deck : ");
            String s = j.getJeu().lireLigne();
            if (j.getPioche().get(0).getNom() == s) {
                j.getMain().add(j.piocher());
            }
        }
    }
}
