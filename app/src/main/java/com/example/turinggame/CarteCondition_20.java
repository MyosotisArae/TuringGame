package com.example.turinggame;

public class CarteCondition_20 extends CarteCondition {

    public CarteCondition_20() {
        super();
        this.numCarte = 20;
        this.nbConditions = 3;
    }

    public boolean controler(int c1, int c2, int c3){
        int reponse = 2-this.nbDoublons(c1,c2,c3);
        return (this.numCondition == reponse);
    }
}
