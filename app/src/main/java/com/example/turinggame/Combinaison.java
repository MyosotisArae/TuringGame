package com.example.turinggame;

import android.util.Log;

// Represente une combinaison de 3 valeurs, assortie d'un indicateur disant si cette combinaison est valide.
public class Combinaison {
    // Valeurs du triangle, du carre et du rond :
    private int[] forme = new int[3];
    // Ceci indique si la combinaison est selectionnee ou pas (par defaut, elle ne l'est pas)
    private boolean valide;

    public Combinaison(int c1, int c2, int c3) {
        this.forme[0] = c1;
        this.forme[1] = c2;
        this.forme[2] = c3;
        this.valide = false;
    }

    public String getCombinaison() {
        return "("+this.forme[0]+","+this.forme[1]+","+this.forme[2]+")";
    }

    // Indique si cette combinaison est valide.
    public boolean getOn() {
        return this.valide;
    }

    // Valide cette combinaison
    public void setOn() {
        this.valide = true;
    }

    // Met a jour le statut "valide" de cette combinaison pour la condition fournie
    public void majSelonCondition(CarteCondition cc) {
        this.valide = cc.controler(this.forme[0],this.forme[1],this.forme[2]);
    }

    // Verifie si cette combinaison correspond a cette carte de controle
    public boolean isIdentique (MatriceControler carteCTRL, TotaliteDesCartesPerforees listeCartesPerforees) {
        // Retrouver les matrices des 3 cartes perforees dans listeCartesPerforees
        MatriceCarte cp[] = new MatriceCarte[3];
        int ordre = 3;
        while (ordre > 0) {
            ordre--;
            cp[ordre] = listeCartesPerforees.get(this.forme[ordre],ordre+1);
        }
        // Comparer le retour de la carte de controle sur ce code avec la valeur (valide ou pas) de cette combinaison
        // Retourner true si les deux retournent faux ainsi que si les deux retournent vrai
        return (carteCTRL.IsCombinaisonCompatible(cp[0],cp[1],cp[2]) == this.valide);
    }
}
