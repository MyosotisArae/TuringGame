package com.example.turinggame;

import android.util.Log;

public class CarteCondition_34 extends CarteCondition {

    public CarteCondition_34() {
        super();
        this.numCarte = 34;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        return (this.plusPetit_plusGrand(true,false,c1,c2,c3, this.numCondition));
    }
}
