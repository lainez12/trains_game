package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class TrainPostal extends Carte {
    public TrainPostal() {
        super("Train postal", 4, 1, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        joueur.setArgent(joueur.getArgent() + 1);

        String rep = " ";
        Set<String> choix = new HashSet<>();
        for (Carte i : joueur.getMain()) {
            choix.add(i.getNom());
        }

        while (rep != "" && !joueur.getMain().isEmpty()) {
            rep = joueur.choisir("Défausser autant de carte que vous le vouler pour gagner 1 d'argent par carte defausser",choix,null,true);
            if (rep != ""){
                Carte temp = joueur.getMain().getCarte(rep);
                joueur.getMain().retirer(rep);
                joueur.getDefausse().add(temp);
                joueur.setArgent(joueur.getArgent() + 1);
                choix.remove(temp);
            }
            if (choix.isEmpty()){
                break;
            }
        }
    }
}
