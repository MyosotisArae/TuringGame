package com.example.turinggame;

public class CarteCondition_24 extends CarteCondition {

    public CarteCondition_24() {
        super();
        this.numCarte = 24;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        int nbCroissant = 0;
        if (c1+1 == c2) { nbCroissant++; }
        if (c2+1 == c3) { nbCroissant++; }
        return (2-nbCroissant == this.numCondition);
    }
}
