package com.example.turinggame;

public class CarteCondition_16 extends CarteCondition {

    public CarteCondition_16() {
        super();
        this.numCarte = 16;
    }

    public boolean controler(int c1, int c2, int c3){
        int nbPair = 0;
        int nbImpair = 0;
        if (c1 % 2 == 0) { nbPair++; } else { nbImpair++; }
        if (c2 % 2 == 0) { nbPair++; } else { nbImpair++; }
        if (c3 % 2 == 0) { nbPair++; } else { nbImpair++; }
        if (this.numCondition == 0 && (nbPair > nbImpair)) return true;
        if (this.numCondition == 1 && (nbPair < nbImpair)) return true;
        return false;
    }
}
