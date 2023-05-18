package com.example.turinggame;

public class CarteCondition_08   extends CarteCondition {

    public CarteCondition_08() {
        super();
        this.numCarte = 8;
        this.nbConditions = 4;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == this.compterChiffre(1, c1,c2,c3));
    }
}
