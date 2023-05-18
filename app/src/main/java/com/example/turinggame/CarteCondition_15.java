package com.example.turinggame;

public class CarteCondition_15 extends CarteCondition {

    public CarteCondition_15() {
        super();
        this.numCarte = 15;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.plusPetit_plusGrand(false,true,c1,c2,c3, this.numCondition));
    }
}
