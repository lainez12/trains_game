package fr.umontpellier.iut.trains.plateau;

import fr.umontpellier.iut.trains.Joueur;
import fr.umontpellier.iut.trains.cartes.ListeDeCartes;
import fr.umontpellier.iut.trains.cartes.PontEnAcier;
import fr.umontpellier.iut.trains.cartes.Tunnel;
import fr.umontpellier.iut.trains.cartes.VoieSouterraine;

/**
 * Classe représentant une tuile plaine, fleuve ou montagne.
 */
public class TuileTerrain extends Tuile {
    /**
     * Type de terrain de la tuile ({@code PLAINE}, {@code FLEUVE} ou
     * {@code MONTAGNE})
     */
    private TypeTerrain type;

    public TuileTerrain(TypeTerrain type) {
        super();
        this.type = type;
    }

    public TypeTerrain getType() {
        return type;
    }

    @Override
    public int getSurcout(ListeDeCartes l) {
        if (Joueur.estEnJeu(l, VoieSouterraine.class))
            return 0;
        switch (type) {
            case FLEUVE:
                if (Joueur.estEnJeu(l, PontEnAcier.class))
                    return 0;
                return 1 + super.getSurcout(l);
            case MONTAGNE:
                if (Joueur.estEnJeu(l, Tunnel.class))
                    return 0;
                return 2 + super.getSurcout(l);
            default:
                return super.getSurcout(l);
        }
    }
}
