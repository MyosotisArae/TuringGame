package com.example.turinggame;

public class CarteCondition_21 extends CarteCondition {

    public CarteCondition_21() {
        super();
        this.numCarte = 21;
    }

    public boolean controler(int c1, int c2, int c3){
        int reponse = 0;
        if (this.nbDoublons(c1,c2,c3)==1) { reponse = 1; }
        return (this.numCondition == reponse);
    }
}
