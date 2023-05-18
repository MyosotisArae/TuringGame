package com.example.turinggame;

public class CarteCondition_38 extends CarteCondition {

    public CarteCondition_38() {
        super();
        this.numCarte = 38;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        int somme;
        switch (this.numCondition){
            case 0 : somme = c1+c2; break;
            case 1 : somme = c1+c3; break;
            case 2 : somme = c2+c3; break;
            default: return false;
        }
        return (somme == 6);
    }
}
