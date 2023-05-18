package com.example.turinggame;

public class CarteCondition_26 extends CarteCondition {

    public CarteCondition_26() {
        super();
        this.numCarte = 26;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        if (this.comparerChiffres(this.numCondition,3,c1,c2,c3) == 0) { return true; }
        return false;
    }
}
