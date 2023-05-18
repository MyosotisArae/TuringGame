package com.example.turinggame;

public class CarteCondition_07  extends CarteCondition {

    public CarteCondition_07() {
        super();
        this.numCarte = 7;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == (c3 % 2));
    }
}
