package com.example.turinggame;

public class CarteCondition_29 extends CarteCondition {

    public CarteCondition_29() {
        super();
        this.numCarte = 29;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        if (this.comparerChiffres(this.numCondition,3,c1,c2,c3) == 1) { return true; }
        return false;
    }
}
