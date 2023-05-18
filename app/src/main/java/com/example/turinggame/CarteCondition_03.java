package com.example.turinggame;

public class CarteCondition_03 extends CarteCondition {

    public CarteCondition_03() {
        super();
        this.numCarte = 3;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.comparerChiffres(c2, 3));
    }
}
