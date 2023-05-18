package com.example.turinggame;

public class CarteCondition_13 extends CarteCondition {

    public CarteCondition_13() {
        super();
        this.numCarte = 13;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.comparerChiffres(c2, c3));
    }
}
