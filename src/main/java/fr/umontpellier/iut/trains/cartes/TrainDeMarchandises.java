package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class TrainDeMarchandises extends Carte {
    public TrainDeMarchandises() {
        super("Train de marchandises", 4, 1, CouleurCarte.BLEU);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        joueur.setArgent(joueur.getArgent() + 1);

        String rep = " ";
        Set<String> choix = new HashSet<>();
        choix.add("Ferraille");

        while (rep != "" && joueur.getMain().count("Ferraille") != 0) {
            rep = joueur.choisir("Voulez vous mettre la feraille de vore main dans la pile feraille",choix,null,true);
            if (rep != ""){
                Ferraille f = new Ferraille();
                joueur.getMain().retirer("Ferraille");
                joueur.getJeu().getReserve().get("Ferraille").add(f);
                joueur.setArgent(joueur.getArgent() + 1);
            }
        }
    }
}
