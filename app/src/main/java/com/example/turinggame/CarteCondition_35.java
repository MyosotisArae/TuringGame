package com.example.turinggame;

public class CarteCondition_35 extends CarteCondition {

    public CarteCondition_35() {
        super();
        this.numCarte = 35;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.plusPetit_plusGrand(false,false,c1,c2,c3,this.numCondition));
    }
}
