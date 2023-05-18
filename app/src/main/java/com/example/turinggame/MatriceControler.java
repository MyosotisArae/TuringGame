package com.example.turinggame;

import android.util.Log;

import com.example.turinggame.Matrice;
import com.example.turinggame.MatriceCarte;

// Cette classe represente une carte de controle.
public class MatriceControler extends Matrice {
    protected int numeroJaune=0,numeroBleu=0,numeroViolet=0;

    public MatriceControler(int vert, int jaune, int bleu, int violet) {
        super(vert);
        this.numeroJaune = jaune;
        this.numeroBleu = bleu;
        this.numeroViolet = violet;
    }

    // Indique si le numero fourni est un des 4 numeros identifiant cette carte
    public boolean Cmoi(int num) {
        if (this.numeroCarte == num)  { return true; }
        if (this.numeroJaune == num)  { return true; }
        if (this.numeroBleu == num)   { return true; }
        if (this.numeroViolet == num) { return true; }
        return false;
    }

    public String getNumeros() {
        return " ( vert[" + this.numeroCarte + "] ; jaune[" + this.numeroJaune+"] ; bleu[" + this.numeroBleu + "] ; violet[" + this.numeroViolet+"] ) ";
    }

    /**********************************************************/
    /*        Fonctions de controle                           */
    /**********************************************************/

    // Verifie si cette combinaison donne true ou false pour cette carte de controle
    public boolean IsCombinaisonCompatible(MatriceCarte cp1, MatriceCarte cp2, MatriceCarte cp3) {
        int x = 2; // Les cartes n'ont pas de valeur en 0 et 1 de la 1ère ligne
        int y = 0;
        while (y < this.taille){
            while (x < taille) {
                // Est-ce LA position ou les 3 cartes ont un trou commun ?
                if (cp1.isOK(x,y) && cp2.isOK(x,y) && cp3.isOK(x,y)) {
                    // Retourner la valeur de la carte de controle a cette position
                    return this.isOK(x,y);
                }
                x++;
            }
            y++;
            x = 0;
        }
        // Aucune correspondance trouvée (donc aucun trou commun trouvé sur les 3 cartes perforées, ce qui ne devrait jamais arriver).
        Log.d("ERREUR MatriceControler","Aucun trou commun entre les cartes de la combinaison "+cp1.getChiffre()+","+cp2.getChiffre()+","+cp3.getChiffre());
        return false;
    }

    // Verifie si cette carte de controle donne exactement les mêmes reponses que celles des combinaisons listeCombinaisons
    public boolean IsConditionCompatible(TotaliteDesCartesPerforees listeCartesPerforees, TotaliteDesCombinaisons listeCombinaisons) {
        boolean toutConcorde = true;
        int numCombinaison = listeCombinaisons.getNb();
        while (numCombinaison > 0) {
            numCombinaison--;
        }
        return toutConcorde;
    }
}
