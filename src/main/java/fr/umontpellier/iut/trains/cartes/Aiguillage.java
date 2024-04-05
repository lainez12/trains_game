package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Aiguillage extends Carte {
    public Aiguillage() {
        super("Aiguillage", 5, 0, CouleurCarte.ROUGE);
    }

    public int getPrix() {
        return 5;
    }
    @Override
    public void jouer(Joueur j){
        List<Carte> cartepiocher = new ListeDeCartes();
        cartepiocher = j.piocher(2);
        for (int i = 0; i < cartepiocher.size(); i++) {
            j.getMain().add(cartepiocher.get(i));
        }
    }
}
