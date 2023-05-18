package com.example.turinggame;

public class CarteCondition_41 extends CarteCondition {

    public CarteCondition_41() {
        super();
        this.numCarte = 41;
        this.nbConditions = 9;
    }

    // Condition : bleu/jaune/violet compare a 3
    public boolean controler(int c1, int c2, int c3){
        int couleur = this.numCondition / 3;
        // ligne 1 => condition = "couleur < 4 ?"
        if (this.numCondition % 3 == 0) {
            if (this.comparerChiffres(couleur, 4, c1, c2, c3) == 0) {
                return true;
            } else return false;
        }
        // ligne 2 => condition = "couleur = 4 ?"
        if (this.numCondition % 3 == 0) {
            if (this.comparerChiffres(couleur, 4, c1, c2, c3) == 1) {
                return true;
            } else return false;
        }
        // ligne 3 => condition = "couleur > 4 ?"
        if (this.numCondition % 3 == 0) {
            if (this.comparerChiffres(couleur, 4, c1, c2, c3) == 2) {
                return true;
            } else return false;
        }
        return false;
    }
}
