package com.example.turinggame;

public class CarteCondition_47 extends CarteCondition {

    public CarteCondition_47() {
        super();
        this.numCarte = 47;
        this.nbConditions = 8;
    }

    // Cette fonction retourne true si la carte de controle est compatible avec la condition actuelle
    /*
    public boolean IsCompatibleAvecCTRL(MatriceControler mc) {
        switch(mc.getVert()) {
            case 286 : return true;
            default: return false;
        }
    }
    */

    // Combien de 1 / de 4 dans le code
    public boolean controler(int c1, int c2, int c3){
        // ligne 1 : combien de 1 ? numCondition = 0 a 3
        int combienDe = 1;
        int nbAttendu = this.numCondition;
        // ligne 2 : combien de 4 ? numCondition = 4 a 7
        if (this.numCondition > 3){ combienDe = 4; nbAttendu -= 3; }
        // colonne 1 : aucun, numCondition=0 ou 4
        // colonne 2 : un seul, numCondition=1 ou 5
        // colonne 3 : deux, numCondition=2 ou 6
        // colonne 4 : trois, numCondition=3 ou 7
        return this.compterChiffre(combienDe, c1,c2,c3) == nbAttendu;
    }
}
