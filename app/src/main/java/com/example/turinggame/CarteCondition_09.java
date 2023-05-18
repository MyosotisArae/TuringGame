package com.example.turinggame;

public class CarteCondition_09 extends CarteCondition {

    public CarteCondition_09() {
        super();
        this.numCarte = 9;
        this.nbConditions = 4;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.compterChiffre(3, c1,c2,c3));
    }
}
