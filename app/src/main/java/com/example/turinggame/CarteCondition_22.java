package com.example.turinggame;

public class CarteCondition_22 extends CarteCondition {

    public CarteCondition_22() {
        super();
        this.numCarte = 22;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        switch (this.numCondition) {
            case 0 : return (c1 < c2 && c2 < c3);
            case 1 : return (c1 > c2 && c2 > c3);
            case 2 : if (c1 < c2 && c2 < c3) { return false; }
                     if (c1 > c2 && c2 > c3) { return false; }
                     return true;
        }
        return false;
    }
}
