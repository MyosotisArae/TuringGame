package com.example.turinggame;

public class CarteCondition_18 extends CarteCondition {

    public CarteCondition_18() {
        super();
        this.numCarte = 18;
    }

    public boolean controler(int c1, int c2, int c3){
        int somme = c1+c2+c3;
        return (somme % 2 == this.numCondition);
    }
}
