package com.example.turinggame;

public class CarteCondition_36 extends CarteCondition {

    public CarteCondition_36() {
        super();
        this.numCarte = 36;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        int somme = c1+c2+c3;
        switch (this.numCondition){
            // Somme multiple de 3 :
            case 0 : return (somme % 3 == 0);
            // Somme multiple de 4 :
            case 1 : return (somme % 4 == 0);
            // Somme multiple de 5 :
            case 2 : return (somme % 5 == 0);
            // Numero de condition hors limite
            default : return false;
        }
    }
}
