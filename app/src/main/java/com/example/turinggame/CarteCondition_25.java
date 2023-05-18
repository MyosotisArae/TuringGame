package com.example.turinggame;

public class CarteCondition_25 extends CarteCondition {

    public CarteCondition_25() {
        super();
        this.numCarte = 25;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        int nbCroissant = 0;
        int nbDecroissant = 0;
        if (c1+1 == c2) { nbCroissant++; }
        if (c2+1 == c3) { nbCroissant++; }
        if (c2+1 == c1) { nbDecroissant++; }
        if (c3+1 == c2) { nbDecroissant++; }

        // Condition 0 : aucune valeur consecutives
        if (this.numCondition==0 && nbCroissant==0 && nbDecroissant==0) { return true; }
        // Condition 1 : 2 valeurs consecutives
        if (this.numCondition==1 && (nbCroissant==1 || nbDecroissant==0)) { return true; }
        // Condition 2 : 3 valeurs consecutives
        if (this.numCondition==1 && (nbCroissant==2 || nbDecroissant==2)) { return true; }
        return false;
    }
}