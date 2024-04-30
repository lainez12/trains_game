package fr.umontpellier.iut.trains;

import fr.umontpellier.iut.trains.cartes.TrainExpress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testFinJeu extends BaseTestClass {
    @Test
    void test_fin_jeu_si_plus_de_jetons_gare() {
        setupJeu();

        // Le joueur 1 choisit de placer son premier rail sur la tuile 14 puis le joueur
        // 2 choisit de placer son premier rail sur la tuile 62
        jeu.setInput("TUILE:14", "TUILE:62");
        jeu.setNbJetonsGare(0);
        assertEquals(true, jeu.estFini());
        jeu.setNbJetonsGare(4);
        assertEquals(false, jeu.estFini());
        jeu.setNbJetonsGare(-2);
        assertEquals(true, jeu.estFini());
    }

    @Test
    void test_fin_jeu_si_plus_de_jetons_rails() {
        setupJeu();

        // Le joueur 1 choisit de placer son premier rail sur la tuile 14 puis le joueur
        // 2 choisit de placer son premier rail sur la tuile 62
        jeu.setInput("TUILE:14", "TUILE:62");
        jeu.getJoueurCourant().setNbJetonsRails(0);
        assertEquals(true, jeu.estFini());
        jeu.getJoueurCourant().setNbJetonsRails(12);
        assertEquals(false, jeu.estFini());
        jeu.getJoueurCourant().setNbJetonsRails(0);
        assertEquals(true, jeu.estFini());
    }

    @Test
    void test_fin_jeu_si_au_moins_quatre_piles_vide() {
        setupJeu();

        // Le joueur 1 choisit de placer son premier rail sur la tuile 14 puis le joueur
        // 2 choisit de placer son premier rail sur la tuile 62
        jeu.setInput("TUILE:14", "TUILE:62");
        jeu.getReserve().get("Train express").clear();
        assertEquals(false, jeu.estFini());
        jeu.getReserve().get("Train direct").clear();
        jeu.getReserve().get("Appartement").clear();
        jeu.getReserve().get("Ferraille").clear();
        assertEquals(false, jeu.estFini());
        jeu.getReserve().get("Immeuble").clear();
        assertEquals(true, jeu.estFini());
    }

}