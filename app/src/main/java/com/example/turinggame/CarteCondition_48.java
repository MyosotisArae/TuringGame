package com.example.turinggame;

public class CarteCondition_48 extends CarteCondition {

    public CarteCondition_48() {
        super();
        this.numCarte = 48;
        this.nbConditions = 9;
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

    // Cpmpare bleu et jaune ou bleu et violet ou jaune et violet
    public boolean controler(int c1, int c2, int c3){
        switch (this.numCondition){
            case 0 :
            case 3 :
            case 6 : return this.comparerChiffres(c1, c2) == this.numCondition;
            case 1 :
            case 4 :
            case 7 : return this.comparerChiffres(c1, c3) == this.numCondition;
            case 2 :
            case 5 :
            case 8 : return this.comparerChiffres(c2, c3) == this.numCondition;
            default: return false;
        }
    }
}
