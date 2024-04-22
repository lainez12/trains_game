package fr.umontpellier.iut.trains.cartes;

import java.util.ArrayList;
import java.util.List;

import fr.umontpellier.iut.trains.Joueur;

public class CentreDeRenseignements extends Carte {
    public CentreDeRenseignements() {
        super("Centre de renseignements", 4, 1, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur j) {
        j.setArgent(j.getArgent() + getValeur());
        List<Carte> cartePioche = j.piocher(4);
        ArrayList<String> choix = new ArrayList<>();
        for (Carte i : cartePioche) {
            choix.add(i.getNom());
            j.log("-" + i.getNom() + "-");
        }
        if (choix.isEmpty()) {
            j.choisir("Il n'y a plus de carte, veuillez passer.", choix, null, true);
        } else {
            String res = j.choisir("Choisissez la carte que vous voulez garder (ou pas).", choix, null, true);
            if (res != "") {
                int temp = choix.indexOf(res);
                j.getMain().add(cartePioche.remove(temp));
                choix.remove(temp);
            }
        }
        int temp = cartePioche.size();
        for (int i = 0; i < temp; i++) {
            String res = j.choisir("Remettez une à une les cartes...", choix, null, false);
            j.getPioche().add(0, cartePioche.remove(choix.indexOf(res)));
            choix.remove(choix.indexOf(res));
        }
    }
}
