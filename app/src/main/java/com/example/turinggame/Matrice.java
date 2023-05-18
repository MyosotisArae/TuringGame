package com.example.turinggame;

import android.util.Log;

public class Matrice {
    protected int taille = 12;
    private boolean[][] valeur = new boolean[taille][taille];
    protected int numeroCarte;

    public Matrice(int num) {
        this.numeroCarte = num;

        for (int x=0; x<this.taille; x++){
            for (int y=0; y<this.taille; y++)
                this.valeur[x][y] = false;
        }
    }

    protected int getNumeroCarte() {
        return this.numeroCarte;
    }

    // Appeler cette fonction pour mettre une case de la matrice à TRUE
    public void setOn(int x, int y){
        //Log.d("Matrice","setOn : x="+x+", y="+y);
        this.valeur[x][y] = true;
    }

    // Appeler cette fonction pour mettre une case de la matrice à FALSE
    public void setOff(int x, int y){
        this.valeur[x][y] = false;
    }

    // Donne la valeur à cette position de la carte.
    public boolean isOK(int x, int y){
        return this.valeur[x][y];
    }

    // Compare la carte actuelle avec 3 autres cartes
    public boolean compare(Matrice carte1, Matrice carte2, Matrice carte3){
        for (int x=0; x<this.taille; x++){
            for (int y=0; y<this.taille; y++)
                if (this.valeur[x][y]) {
                    // Cette carte vaut TRUE à cette position. La comparer avec les autres cartes.
                    if (carte1.isOK(x,y)){
                        if (carte2.isOK(x,y)){
                            if (carte3.isOK(x,y)){
                                return true; // Les 4 cartes ont "TRUE" en (x,y)
                            }
                        }
                    }
                }
        }
        return false;
    }
}
