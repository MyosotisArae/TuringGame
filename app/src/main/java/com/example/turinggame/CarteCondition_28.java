package com.example.turinggame;

public class CarteCondition_28 extends CarteCondition {

    public CarteCondition_28() {
        super();
        this.numCarte = 28;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        if (this.comparerChiffres(this.numCondition,1,c1,c2,c3) == 1) { return true; }
        return false;
    }
}
