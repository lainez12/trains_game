package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class PassageEnGare extends Carte {
    public PassageEnGare() {
        super("Passage en gare", 3, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        Carte temp = joueur.piocher();
        if (temp != null){
            joueur.getMain().add(temp);
        }
        joueur.setArgent(joueur.getArgent() + 1);
    }
}
