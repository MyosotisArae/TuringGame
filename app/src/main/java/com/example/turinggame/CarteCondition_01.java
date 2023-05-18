package com.example.turinggame;

import com.example.turinggame.CarteCondition;
import com.example.turinggame.MatriceCarte;

// Ceci represente une carte qui verifie une ou plusieurs conditions.
public class CarteCondition_01 extends CarteCondition {

    public CarteCondition_01() {
        super();
        this.numCarte = 1;
    }

    public boolean controler(int c1, int c2, int c3){
        switch (this.numCondition){
            case 0 : if (c1==1)  { return true; } break;
            case 1 : if (c1 > 1) { return true; } break;
        }
        return false;
    }
}
