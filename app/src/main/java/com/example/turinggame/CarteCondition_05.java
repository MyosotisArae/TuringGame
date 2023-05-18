package com.example.turinggame;

public class CarteCondition_05 extends CarteCondition {

    public CarteCondition_05() {
        super();
        this.numCarte = 5;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.numCondition == (c1 % 2));
    }
}
