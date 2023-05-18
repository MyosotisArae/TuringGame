package com.example.turinggame;

public class CarteCondition_12 extends CarteCondition {

    public CarteCondition_12() {
        super();
        this.numCarte = 12;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.comparerChiffres(c1, c3));
    }
}
