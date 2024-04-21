package fr.umontpellier.iut.trains.cartes;

import java.util.List;

import fr.umontpellier.iut.trains.Joueur;

public class CentreDeRenseignements extends Carte {
    public CentreDeRenseignements() {
        super("Centre de renseignements", 4, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        List<Carte> cartePioche = new ListeDeCartes();
        cartePioche = j.piocher(4);
        for (Carte i : cartePioche) {
            j.getMain().add(i);
        }
    }
}
