package com.example.turinggame;

public class CarteCondition_02 extends CarteCondition {

    public CarteCondition_02() {
        super();
        this.numCarte = 2;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.comparerChiffres(c1, 3));
    }
}