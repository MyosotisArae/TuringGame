package com.example.turinggame;

public class CarteCondition_10 extends CarteCondition {

    public CarteCondition_10() {
        super();
        this.numCarte = 10;
        this.nbConditions = 4;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.compterChiffre(4, c1,c2,c3));
    }
}
