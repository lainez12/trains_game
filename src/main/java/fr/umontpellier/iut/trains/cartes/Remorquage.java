package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class Remorquage extends Carte {
    public Remorquage() {
        super("Remorquage", 3, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);
        Set<String> choix = new HashSet<>();
        String rep = "";
        for (int i = 0; i < joueur.getDefausse().size(); i++) {
            if (joueur.getDefausse().get(i).getCouleur() == CouleurCarte.BLEU) {
                choix.add(joueur.getDefausse().get(i).getNom());
            }
        }
        if (choix.isEmpty()){
            rep = joueur.choisir("Vous devez passer car vous n'avez pas de carte train dans votre defausse", choix, null, true);
        }
        else {
            rep = joueur.choisir("Choisissez une carte Train de votre main pour l'écarter", choix, null, false);
            Carte temp = joueur.getDefausse().getCarte(rep);
            joueur.getDefausse().retirer(rep);
            joueur.getMain().add(temp);
        }
    }
}
