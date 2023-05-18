package com.example.turinggame;

public class CarteCondition_23 extends CarteCondition {

    public CarteCondition_23() {
        super();
        this.numCarte = 23;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        int somme = c1+c2+c3;
        return (this.comparerChiffres(somme,6) == this.numCondition);
    }
}
