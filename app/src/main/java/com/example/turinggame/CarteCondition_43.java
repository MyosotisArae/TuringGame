package com.example.turinggame;

public class CarteCondition_43 extends CarteCondition {

    public CarteCondition_43() {
        super();
        this.numCarte = 43;
        this.nbConditions = 6;
    }

    // Bleu compare à jaune / violet
    public boolean controler(int c1, int c2, int c3){
        // Ligne 1 :
        //     numCondition est pair (0/2/4)
        //     bleu compare a jaune
        //     comparaison = 0/1/2 = numCondition:2
        // Ligne 2 :
        //     numCondition est impair (1/3/5)
        //     bleu compare a violet
        //     comparaison = 0/1/2 = (numCondition-1):2 = numCondition:2 en division entiere
        int v1 = c1;
        int v2 = c3;
        int reponseAttendue = this.numCondition/2;
        if (this.numCondition % 2 == 0) { v2 = c2; }
        return (reponseAttendue == this.comparerChiffres(v1,v2));
    }
}
