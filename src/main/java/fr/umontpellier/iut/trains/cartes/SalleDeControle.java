package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.List;

public class SalleDeControle extends Carte {
    public SalleDeControle() {
        super("Salle de contrôle", 7, 0, CouleurCarte.ROUGE);
    }
    public void jouer(Joueur j){
        List<Carte> cartepiocher = new ListeDeCartes();
        cartepiocher = j.piocher(3);
        if (cartepiocher != null){
            for (int i = 0; i < cartepiocher.size(); i++) {
                j.getMain().add(cartepiocher.get(i));
            }
        }
    }
}
