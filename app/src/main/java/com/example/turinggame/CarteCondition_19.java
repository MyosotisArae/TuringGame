package com.example.turinggame;

public class CarteCondition_19 extends CarteCondition {

    public CarteCondition_19() {
        super();
        this.numCarte = 19;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        int somme = c1+c2;
        switch (this.numCondition){
            case 0 : return (somme < 6);
            case 1 : return (somme == 6);
            case 2 : return (somme > 6);
        }
        return false;
    }
}
