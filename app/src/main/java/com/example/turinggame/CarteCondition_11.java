package com.example.turinggame;

public class CarteCondition_11 extends CarteCondition {

    public CarteCondition_11() {
        super();
        this.numCarte = 11;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.comparerChiffres(c1, c2));
    }
}
