package com.example.turinggame;

import android.util.Log;

@FunctionalInterface
interface Fonction {
    boolean run(int a,int b);
}

// Ceci represente une carte qui verifie une ou plusieurs conditions.
public class CarteCondition {
    protected int numCarte;
    protected int numCondition;
    protected int nbConditions;
    protected int[][] carteCtrlCompatible;

    public CarteCondition() {
        // Les cartes simples n'ont que 2 cas possibles :
        this.nbConditions = 2;
        this.numCondition = 0;
    }

    // Cette fonction retourne true si la carte de controle est compatible avec la condition actuelle
    /*
    public boolean IsCompatibleAvecCTRL(MatriceControler mc) {
        return false;
    }
    */

    // Cette fonction retourne TRUE si la condition numCondition
    // est verifiee par la COMBINAISON passée en parametre :
    public boolean controler(int c1, int c2, int c3){
        return false;
    }

    public int getCondition(){
        return this.numCondition;
    }

    public void setCondition(int n){
        this.numCondition = n;
    }

    public int getNbConditions(){
        return this.nbConditions;
    }

    public int getNumCarte(){
        return this.numCarte;
    }

    /**********************************************************/
    /*        Autres fonctions de controle                    */
    /**********************************************************/

    // Verifie si un code peut correspondre a une des conditions de cette carte
    public boolean IsCombinaisonCompatible(int c1, int c2, int c3) {
        // Sauvegarder la valeur de numCondition afin de ne pas changer sa valeur
        int sauvegarde = this.numCondition;
        this.numCondition = this.nbConditions;
        while (this.numCondition > 0) {
            this.numCondition--;
            if (this.controler(c1,c2,c3)) {
                this.numCondition = sauvegarde;
                return true;
            }
        }
        this.numCondition = sauvegarde;
        return false;
    }

    /**********************************************************/
    /*        Fonctions utilisees dans plusieurs cartes       */
    /**********************************************************/

    // Compter le nombre d'occurences d'un chiffre dans le code
    protected int compterChiffre(int chiffre, int c1, int c2, int c3) {
        int comptage = 0;
        if (c1 == chiffre) { comptage++; }
        if (c2 == chiffre) { comptage++; }
        if (c3 == chiffre) { comptage++; }
        return comptage;
    }

    // Comparer un chiffre à un autre
    protected int comparerChiffres(int n1, int n2){
        if (n1<n2) return 0;
        if (n1==n2) return 1;
        return 2;
    }

    // Comparer un des chiffres du code à une valeur
    // numCouleur = numCondition : 0=bleu, 1=jaune, 2=violet
    protected int comparerChiffres(int numCouleur, int valeur, int c1, int c2, int c3) {
        int valeurAcomparer; // Valeur d'une des 3 cartes
        switch (numCouleur){
            case 0 : valeurAcomparer = c1; break;
            case 1 : valeurAcomparer = c2; break;
            case 2 : valeurAcomparer = c3; break;
            default: return -1;
        }
        return this.comparerChiffres(valeurAcomparer,valeur);
    }

    // Nombre de doublons :
    //   222 = 2 doublons
    //   212 = 1 doublon
    //   254 = 0 doublon
    protected int nbDoublons(int c1, int c2, int c3){
        if (c1 == c2 && (c2 == c3)) { return 2; }
        if (c1 == c2) { return 1; }
        if (c1 == c3) { return 1; }
        if (c3 == c2) { return 1; }
        return 0;
    }

    // Qui est le plus petit / le plus grand (strictement ou pas) : 14,15,34,35,42
    // Retourne true si le numero de la couleur qui respecte la condition (0=bleu, 1=jaune, 2=violet) est la valeur attendue
    protected boolean plusPetit_plusGrand(boolean plusPetit, boolean strictement, int v1, int v2, int v3, int valeurAttendue) {
        // 4 opérateurs de comparaison sont possibles
        Fonction PS = (a,b) -> { return (a<b); };
        Fonction GS = (a,b) -> { return (a>b); };
        Fonction PL = (a,b) -> { return (a<=b); };
        Fonction GL = (a,b) -> { return (a>=b); };
        // Operateur à utiliser :
        Fonction op;
        if (plusPetit) {
            if (strictement) { op = PS; }
            else { op = PL; }
        } else {
            if (strictement) {
                op = GS;
            } else {
                op = GL;
            }
        }

        switch (valeurAttendue) {
            // On veut que ce soit le bleu qui respecte la condition
            case 0 : return (op.run(v1,v2) && op.run(v1,v3));
            // On veut que ce soit le jaune qui respecte la condition
            case 1 : return (op.run(v2,v1) && op.run(v2,v3));
            // On veut que ce soit le violet qui respecte la condition
            case 2 : return (op.run(v3,v1) && op.run(v3,v2));
            // Valeur attendue anormale
            default: return false;
        }
        /*
        // Plus petit ?
        if (plusPetit) {
            if (strictement) {
                if (v1 < v2 && v1 < v3) {
                    return 0;
                }
                if (v2 < v1 && v2 < v3) {
                    return 1;
                }
                if (v3 < v1 && v3 < v2) {
                    return 2;
                }
                return -1;
            } else {
                if (v1 <= v2 && v1 <= v3) {
                    return 0;
                }
                if (v2 <= v1 && v2 <= v3) {
                    return 1;
                }
                if (v3 <= v1 && v3 <= v2) {
                    return 2;
                }
            }
        } else {
            if (strictement) {
                if (v1 > v2 && v1 > v3) {
                    return 0;
                }
                if (v2 > v1 && v2 > v3) {
                    return 1;
                }
                if (v3 > v1 && v3 > v2) {
                    return 2;
                }
                return -1;
            } else {
                if (v1 >= v2 && v1 >= v3) {
                    return 0;
                }
                if (v2 >= v1 && v2 >= v3) {
                    return 1;
                }
                if (v3 >= v1 && v3 >= v2) {
                    return 2;
                }
            }
        }
        return -1;
         */
    }
}
