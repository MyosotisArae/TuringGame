package com.example.turinggame;

public class CarteCondition_45 extends CarteCondition {

    public CarteCondition_45() {
        super();
        this.numCarte = 45;
        this.nbConditions = 8;
    }

    // Combien de 1 / de 3 dans le code
    public boolean controler(int c1, int c2, int c3){
        // ligne 1 : combien de 1 ? numCondition = 0 a 3
        int combienDe = 1;
        int nbAttendu = this.numCondition;
        // ligne 2 : combien de 3 ? numCondition = 4 a 7
        if (this.numCondition > 3){ combienDe = 3; nbAttendu -= 3; }
        // colonne 1 : aucun, numCondition=0 ou 4
        // colonne 2 : un seul, numCondition=1 ou 5
        // colonne 3 : deux, numCondition=2 ou 6
        // colonne 4 : trois, numCondition=3 ou 7
        return this.compterChiffre(combienDe, c1,c2,c3) == nbAttendu;
    }
}
