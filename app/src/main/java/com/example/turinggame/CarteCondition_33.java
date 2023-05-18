package com.example.turinggame;

public class CarteCondition_33 extends CarteCondition {

    public CarteCondition_33() {
        super();
        this.numCarte = 33;
        this.nbConditions = 6;
    }

    public boolean controler(int c1, int c2, int c3){
        switch (this.numCondition){
            // Bleu pair :
            case 0 : return c1 % 2 == 0;
            // Bleu impair :
            case 1 : return c1 % 2 == 1;
            // Jaune pair :
            case 2 : return c2 % 2 == 0;
            // Jaune impair :
            case 3 : return c2 % 2 == 1;
            // Violet pair :
            case 4 : return c3 % 2 == 0;
            // Violet impair :
            case 5 : return c3 % 2 == 1;
            // Numero de condition hors limite
            default : return false;
        }
    }
}
