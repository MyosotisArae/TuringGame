package com.example.turinggame;

public class CarteCondition_39 extends CarteCondition {

    public CarteCondition_39() {
        super();
        this.numCarte = 39;
        this.nbConditions = 6;
    }

    // Condition : bleu/jaune/violet egal a 1 ou superieur a 1
    public boolean controler(int c1, int c2, int c3){
        int couleur = this.numCondition / 2;
        // Condition paire : ligne 1 => condition = "couleur = 1 ?"
        if (this.numCondition % 2 == 0) {
            if (this.comparerChiffres(couleur, 1, c1, c2, c3) == 1) {
                return true;
            } else return false;
        } else {
            // Condition impaire : ligne 2 => condition = "couleur > 1 ?"
            if (this.comparerChiffres(couleur, 1, c1, c2, c3) == 2) {
                return true;
            } else return false;
        }
    }
}
