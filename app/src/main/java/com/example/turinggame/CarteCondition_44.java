package com.example.turinggame;

public class CarteCondition_44 extends CarteCondition {

    public CarteCondition_44() {
        super();
        this.numCarte = 44;
        this.nbConditions = 6;
    }

    // Jaune compare à bleu / violet
    public boolean controler(int c1, int c2, int c3){
        // Ligne 1 :
        //     numCondition est pair (0/2/4)
        //     jaune compare a bleu
        //     comparaison = 0/1/2 = numCondition:2
        // Ligne 2 :
        //     numCondition est impair (1/3/5)
        //     jaune compare a violet
        //     comparaison = 0/1/2 = (numCondition-1):2 = numCondition:2 en division entiere
        int v1 = c2;
        int v2 = c3;
        int reponseAttendue = this.numCondition/2;
        if (this.numCondition % 2 == 0) { v2 = c1; }
        return (reponseAttendue == this.comparerChiffres(v1,v2));
    }
}
