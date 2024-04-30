package fr.umontpellier.iut.trains;

import fr.umontpellier.iut.trains.cartes.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTestPERSO extends BaseTestClass {

    @Test
    void test_ajouter_rail_montagne() {
        setupJeu();
        initialisation();
        tuiles.get(23).ajouterRail(joueur);

        Carte pose = new PoseDeRails();
        Carte expr = new TrainExpress();
        addAll(main, pose, expr);

        jouerTourPartiel("Pose de rails", "Train express", "TUILE:14");

        checkPlateau(null, List.of(23, 14), null);
    }

    @Test
    void test_ajouter_rail_lieu_eloigne() {
        setupJeu();
        initialisation();
        tuiles.get(18).ajouterRail(joueur);

        Carte pose = new PoseDeRails();
        Carte expr = new TrainExpress();
        addAll(main, pose, expr, expr);

        jouerTourPartiel("Pose de rails", "Train express", "Train express", "TUILE:9");

        checkPlateau(null, List.of(18, 9), null);
    }

    @Test
    void test_ajouter_rail_montagne_sans_surcout_tunnel() {
        setupJeu();
        initialisation();
        tuiles.get(23).ajouterRail(joueur);

        Carte pose = new Tunnel();
        addAll(main, pose);

        jouerTourPartiel("Tunnel", "TUILE:14");

        checkPlateau(null, List.of(23, 14), null);
    }

    @Test
    void test_ajouter_rail_fleuve_sans_surcout_pont_en_acier() {
        setupJeu();
        initialisation();
        tuiles.get(23).ajouterRail(joueur);

        Carte pose = new PontEnAcier();
        addAll(main, pose);

        jouerTourPartiel("Pont en acier", "TUILE:33");

        checkPlateau(null, List.of(23, 33), null);
    }

    @Test
    void test_ajouter_rail_ville_sans_surcout_gare_et_viaduc() {
        setupJeu();
        initialisation();
        tuiles.get(43).ajouterRail(joueur);

        Carte pose = new Viaduc();
        Carte gare = new Gare();
        addAll(main, gare, pose);

        jouerTourPartiel("Gare", "TUILE:42", "Viaduc", "TUILE:42");

        checkPlateau(null, List.of(43, 42), null);
    }

    @Test
    void test_ajouter_rail_lieu_eloigne_et_rail_adverse_dessus_sans_surcout_cooperation() {
        setupJeu();
        initialisation();
        tuiles.get(9).ajouterRail(joueurs.get(0));
        tuiles.get(18).ajouterRail(joueur);
        joueur.setArgent(3); // argent necéssaire 3

        Carte pose = new Cooperation();
        addAll(main, pose);
        jouerTourPartiel("Coopération", "TUILE:9");

        checkPlateau(List.of(9), List.of(18, 9), null);
    }

    @Test
    void test_ajouter_rail_lieu_eloigne_et_rail_adverse_dessus_avec_surcout() {
        setupJeu();
        initialisation();
        tuiles.get(9).ajouterRail(joueurs.get(0));
        tuiles.get(18).ajouterRail(joueur);
        joueur.setArgent(5); // argent necéssaire 4

        Carte pose = new PoseDeRails();
        addAll(main, pose);
        jouerTourPartiel("Pose de rails", "TUILE:9");

        checkPlateau(List.of(9), List.of(18, 9), null);
        assertEquals(1, joueur.getArgent());
    }

    @Test
    void test_ajouter_rail_montagne_et_rail_adverse_dessus_avec_surcout_uniquement_de_montagne_cooperation() {
        setupJeu();
        initialisation();
        tuiles.get(14).ajouterRail(joueurs.get(0));
        tuiles.get(23).ajouterRail(joueur);
        joueur.setArgent(3); // argent necéssaire 2

        Carte pose = new Cooperation();
        addAll(main, pose);
        jouerTourPartiel("Coopération", "TUILE:14");

        checkPlateau(List.of(14), List.of(23, 14), null);
        assertEquals(1, joueur.getArgent());
    }

    @Test
    void test_ajouter_rail_montagne_et_rail_adverse_dessus_sans_surcout_cooperation_et_tunnel() {
        setupJeu();
        initialisation();
        tuiles.get(14).ajouterRail(joueurs.get(0));
        tuiles.get(23).ajouterRail(joueur);
        joueur.setArgent(0); // argent necéssaire 0

        Carte pose = new Cooperation();
        Carte pose1 = new Tunnel();
        addAll(main, pose, pose1);
        jouerTourPartiel("Coopération", "Tunnel", "TUILE:14");

        checkPlateau(List.of(14), List.of(23, 14), null);
    }

    /*
     * @Test
     * void
     * test_ajouter_rail_ville_et_rail_adverse_dessus_sans_surcout_cooperation() {
     * setupJeu();
     * initialisation();
     * tuiles.get(42).ajouterRail(joueurs.get(0));
     * tuiles.get(42).ajouterGare(joueurs.get(0));
     * tuiles.get(43).ajouterRail(joueur);
     * joueur.setArgent(2); // argent necéssaire 2
     * 
     * Carte pose = new Cooperation();
     * addAll(main, pose);
     * jouerTourPartiel("Coopération", "TUILE:42");
     * 
     * checkPlateau(List.of(42), List.of(43, 42), Map.of(42, 1));
     * assertEquals(0, joueur.getArgent());
     * }
     */
    @Test
    void test_ajouter_rail_montagne_et_rail_adverse_dessus_sans_surcout_voie_souterraine() {
        setupJeu();
        initialisation();
        tuiles.get(14).ajouterRail(joueurs.get(0));
        tuiles.get(23).ajouterRail(joueur);
        joueur.setArgent(0); // argent necéssaire 0

        Carte pose = new VoieSouterraine();
        addAll(main, pose);
        jouerTourPartiel("Voie souterraine", "TUILE:14");

        checkPlateau(List.of(14), List.of(23, 14), null);
        assertEquals(0, joueur.getArgent());
    }

    @Test
    void test_ajouter_rail_lieu_eloigne_et_rail_adverse_dessus_sans_surcout_voie_souterraine() {
        setupJeu();
        initialisation();
        tuiles.get(9).ajouterRail(joueurs.get(0));
        tuiles.get(18).ajouterRail(joueur);
        joueur.setArgent(3); // argent necéssaire 0

        Carte pose = new VoieSouterraine();
        addAll(main, pose);
        jouerTourPartiel("Voie souterraine", "TUILE:9");

        checkPlateau(List.of(9), List.of(18, 9), null);
        assertEquals(3, joueur.getArgent());
    }

    @Test
    void test_ajouter_rail_mer() {
        setupJeu();
        initialisation();
        tuiles.get(41).ajouterRail(joueur);
        joueur.setArgent(2); // argent necéssaire 0

        Carte pose = new PoseDeRails();
        addAll(main, pose);
        jouerTourPartiel("Pose de rails", "TUILE:50");

        checkPlateau(null, List.of(41), null);
        assertEquals(0, tuiles.get(50).getRails().size());
        assertEquals(2, joueur.getArgent());
    }

    @Test
    void test_acheter_immeuble_getscore_et_verif_ferraille() {
        setupJeu();
        initialisation();
        Carte imm = reserve.get("Immeuble").get(0);
        Carte ferraille = reserve.get("Ferraille").get(0);
        joueur.setArgent(6);
        jouerTourPartiel("ACHAT:Immeuble", "");

        // assertTrue(containsReferences(cartesRecues, imm, ferraille));
        assertEquals(1, joueur.getArgent());
        assertEquals(2, joueur.getScoreTotal());
    }

    @Test
    void test_getscoretotal_avec_condition() {
        setupJeu();
        initialisation();
        Carte imm = new Immeuble();
        Carte gratteciel = new GratteCiel();
        Carte tourisme = new TrainDeTourisme();
        addAll(main, imm);
        assertEquals(2, joueur.getScoreTotal());
        addAll(defausse, gratteciel);
        assertEquals(6, joueur.getScoreTotal());
        tuiles.get(9).ajouterRail(joueur);
        assertEquals(9, joueur.getScoreTotal());
        addAll(main, tourisme);
        jouerTourPartiel("Train de tourisme");
        assertEquals(10, joueur.getScoreTotal());
    }

}