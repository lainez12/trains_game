package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.HashSet;
import java.util.Set;

public class PersonnelDeGare extends Carte {
    public PersonnelDeGare() {
        super("Personnel de gare", 2, 0, CouleurCarte.ROUGE);
    }

    @Override
    public void jouer(Joueur joueur) {
        super.jouer(joueur);

        Set<String> choix = new HashSet<>();
        String rep = "";
        choix.add("piocher");
        choix.add("argent");
        choix.add("ferraille");

        rep = joueur.choisir("Choisisser entre piochez une carte, gagner 1 d'argent ou remetre 1 de feraille de votre main sur la pile feraille",choix,null,false);

        if (rep.equals("piocher")){
            Carte temp = joueur.piocher();
            if (temp != null){
                joueur.getMain().add(temp);
            }
        }
        else if (rep.equals("argent")){
            joueur.setArgent(joueur.getArgent() + 1);
        }
        else if (rep.equals("ferraille")){
            if (joueur.getMain().count("Ferraille") != 0){
                Ferraille f = new Ferraille();
                joueur.getJeu().getReserve().get("Ferraille").add(joueur.getMain().retirer("Ferraille"));
            }
        }
    }
}
