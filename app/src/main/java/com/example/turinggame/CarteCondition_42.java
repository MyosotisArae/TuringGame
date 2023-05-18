package com.example.turinggame;

public class CarteCondition_42 extends CarteCondition {

    public CarteCondition_42() {
        super();
        this.numCarte = 42;
        this.nbConditions = 6;
    }

    public boolean controler(int c1, int c2, int c3){
        int numeroRecherche = this.numCondition/2; // 0/1=condition sur le bleu ; 2/3 sur le jaune ; 4/5 sur le violet
        // Condition paire (0/2/4) : ligne du haut de la carte => chercher le plus petit
        if (this.numCondition % 2 == 0){
            return (this.plusPetit_plusGrand(true,true,c1,c2,c3, numeroRecherche));
        }
        // Condition impaire : ligne du bas
        return (this.plusPetit_plusGrand(false,true,c1,c2,c3, numeroRecherche));
    }
}
