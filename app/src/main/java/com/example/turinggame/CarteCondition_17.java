package com.example.turinggame;

public class CarteCondition_17 extends CarteCondition {

    public CarteCondition_17() {
        super();
        this.numCarte = 17;
        this.nbConditions = 4;
    }

    public boolean controler(int c1, int c2, int c3){
        int nbPair = 0;
        if (c1 % 2 == 0) { nbPair++; }
        if (c2 % 2 == 0) { nbPair++; }
        if (c3 % 2 == 0) { nbPair++; }
        return (this.numCondition == nbPair);
    }
}
