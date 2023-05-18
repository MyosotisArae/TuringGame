package com.example.turinggame;

public class CarteCondition_06 extends CarteCondition {

    public CarteCondition_06() {
        super();
        this.numCarte = 6;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == (c2 % 2));
    }
}
