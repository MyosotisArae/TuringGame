package com.example.turinggame;

public class CarteCondition_04  extends CarteCondition {

    public CarteCondition_04() {
        super();
        this.numCarte = 4;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.comparerChiffres(c2, 4));
    }
}
