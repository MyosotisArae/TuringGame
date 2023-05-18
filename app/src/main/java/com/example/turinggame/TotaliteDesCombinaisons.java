package com.example.turinggame;

import android.util.Log;

// Cette classe contient une liste de toutes les combinaisons et va servir a dresser une liste de celles qui son verifiees.
public class TotaliteDesCombinaisons {
    final private int nbCombinaisons = 125;
    private Combinaison[] liste = new Combinaison[nbCombinaisons];

    public TotaliteDesCombinaisons() {
        int bleu=1, jaune=1, violet=1, n = 0;
        while (violet<6) {
            while (jaune<6) {
                while (bleu<6) {
                    this.liste[n] = new Combinaison(bleu,jaune,violet);
                    n++;
                    bleu++;
                }
                jaune++;
                bleu = 1;
            }
            violet++;
            jaune = 1;
        }
    }

    // Retourne le nombre de combinaisons possibles
    public int getNb() {
        return this.nbCombinaisons;
    }

    // Retourne la valeur de la combinaison d'ordre n
    private Combinaison get(int n) {
        return this.liste[n];
    }

    // Indique si la combinaison d'ordre n est valide ou pas
    private boolean isValide(int n) {
        return this.liste[n].getOn();
    }

    // Verifie la condition pour cette combinaison et passe la combinaison a true si c'est le cas
    public void setIfValide(int n, CarteCondition cc) {
        this.liste[n].majSelonCondition(cc);
    }

    // Dans la liste de toutes les combinaisons, coche celles qui verifient la condition
    public void trouverToutesLesCombinaisons(CarteCondition cd) {
        int numCombinaison = this.nbCombinaisons;
        Combinaison combi;
        while (numCombinaison > 0){
            numCombinaison--;
            this.setIfValide(numCombinaison,cd);
        }
    }

    // Verifie si la carte de controle (avec des cartes perforees) verifie les mêmes conditions que this.liste
    public boolean isControleOK(MatriceControler carteCTRL, TotaliteDesCartesPerforees listeCartesPerforees) {
        int numCombi = this.nbCombinaisons;
        while (numCombi > 0) {
            numCombi--;
            if (!this.liste[numCombi].isIdentique(carteCTRL, listeCartesPerforees)) {
                Log.d("Ctrl NOK", "pour la combinaison "+this.liste[numCombi].getCombinaison()+", la carte "+carteCTRL.getNumeros()+" devrait retourner "+this.liste[numCombi].getOn());
                return false;
            }
        }
        // Toutes les cases de la carte de controle renvoient les memes resultats que this.liste
        return true;
    }
}
