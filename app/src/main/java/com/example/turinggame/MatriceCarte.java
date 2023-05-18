package com.example.turinggame;

import com.example.turinggame.Matrice;

// Cette classe represente une carte perforee
public class MatriceCarte extends Matrice {
    // Pour MatriceCarte, numeroCarte est le chiffre  indique sur l'onglet
    // et non un identifiant unique.
    // Ceci est la position de ce chiffre dans le code :
    private int position;// 1 à 3

    public MatriceCarte(int num, int p) {
        super(num);
        this.position = p;
    }

    // Lecture du chiffre de la carte (1 à 5)
    public int getChiffre(){
        return this.getNumeroCarte();
    }

    // Lecture de la position du chiffre (1 à 3)
    public int getPosition(){
        return this.position;
    }

    // Modification du chiffre de la carte (1 à 5)
    public void setChiffre(int ch){
        this.numeroCarte = ch;
    }

    // Indique si la carte a au moins une case valant true;
    /*
    public boolean isTrue() {
        int x = 2;
        int y = 0;
        while (y < this.taille){
            while (x < taille) {
                if (this.getValeur(x,y) == true) { return true; }
                x++;
            }
            y++;
            x = 0;
        }
        return false;
    }
    */
}
