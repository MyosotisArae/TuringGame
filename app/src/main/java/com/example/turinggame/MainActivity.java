package com.example.turinggame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //private final MatriceControler[] listeControl = new MatriceControler[95];
    final private TotaliteDesCartesControle listeCartesControle = new TotaliteDesCartesControle();
    final private TotaliteDesCartesPerforees listeCartesPerforees = new TotaliteDesCartesPerforees();
    final CarteCondition[] listeCC = {
            new CarteCondition_01(),new CarteCondition_02(),new CarteCondition_03(),new CarteCondition_04(),new CarteCondition_05(),
            new CarteCondition_06(),new CarteCondition_07(),new CarteCondition_08(),new CarteCondition_09(),new CarteCondition_10(),
            new CarteCondition_11(),new CarteCondition_12(),new CarteCondition_13(),new CarteCondition_14(),new CarteCondition_15(),
            new CarteCondition_16(),new CarteCondition_17(),new CarteCondition_18(),new CarteCondition_19(),new CarteCondition_20(),
            new CarteCondition_21(),new CarteCondition_22(),new CarteCondition_23(),new CarteCondition_24(),new CarteCondition_25(),
            new CarteCondition_26(),new CarteCondition_27(),new CarteCondition_28(),new CarteCondition_29(),new CarteCondition_30(),
            new CarteCondition_31(),new CarteCondition_32(),new CarteCondition_33(),new CarteCondition_34(),new CarteCondition_35(),
            new CarteCondition_36(),new CarteCondition_37(),new CarteCondition_38(),new CarteCondition_39(),new CarteCondition_40(),
            new CarteCondition_41(),new CarteCondition_42(),new CarteCondition_43(),new CarteCondition_44(),new CarteCondition_45(),
            new CarteCondition_46(),new CarteCondition_47(),new CarteCondition_48()};

    // Objets de l'interface graphique
    EditText etCarteCondition,etIndiceCondition;
    EditText etControle;
    TextView tvReponse;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initCartesDeControle();
        this.etCarteCondition = findViewById(R.id.numeroCarteCondition);
        this.etIndiceCondition = findViewById(R.id.numeroDeCondition);
        this.tvReponse = findViewById(R.id.reponse);
        this.etControle = findViewById(R.id.numeroDeCarteControle);
    }

    /***** FONCTIONS GRAPHIQUES - DEBUT *****/

    // Affiche le texte fourni dans le textview reponse
    private void afficherReponse(String texte) {
        this.tvReponse.setText(texte);

        // Après avoir affiché le résultat, effacer la saisie
        this.etCarteCondition.setText("");
        this.etIndiceCondition.setText("");
        this.etControle.setText("");
    }

    // bouton : Quels contrôleurs pour cette carte ?
    // Affiche les numeros des cartes de controle permettant de verifier la carte condition saisie
    public void trouverControleurPourCarteCondition(View view) {
        this.genericFunctiontrouverControleurPourCarteCondition(true,false);
    }

    // Boutoon de vérification d'une carte de contrôle
    public void trouverConditionsPourCarteControle(View view) {
        this.genericFunctiontrouverControleurPourCarteCondition(false,true);
    }

    // bouton de verification de condition ET de carte contrôle
    public void validerConditionEtCarteControle(View view) {
        this.genericFunctiontrouverControleurPourCarteCondition(true,true);
    }

    /***** FONCTIONS GRAPHIQUES - FIN *****/

    // Si carteConditionMentionnee=true, cette fonction verifie une carte condition :
    // - avec l'indice de sa condition s'il est renseigné (sinon, toutes les conditions sont vérifiées)
    // - avec une carte de contrôle précise si son numéro est renseigné (ou sinon, avec toutes les cartes de contrôle)
    // Sinon, elle trouve toutes les conditions qui conviennent pour la carte de contrôle
    private void genericFunctiontrouverControleurPourCarteCondition(boolean carteConditionMentionnee,boolean controleMentionne) {
        int numCarteCondition;
        boolean conditionMentionnee = false;
        CarteCondition cc = new CarteCondition();

        if (carteConditionMentionnee) {
            // Trouver le numero de la carte dans l'interface
            numCarteCondition = Integer.parseInt(this.etCarteCondition.getText().toString());
            cc = this.listeCC[numCarteCondition - 1];

            // Si l'indice de la condition est précisé, il n'y aura pas besoin de scanner toutes les conditions
            if (this.etIndiceCondition.getText().toString().length() > 0) {
                cc.setCondition(Integer.parseInt(this.etIndiceCondition.getText().toString()));
                conditionMentionnee = true;
            }
        }

        if (controleMentionne) {
            String numeroCarteCtrl = this.etControle.getText().toString();
            if (numeroCarteCtrl.length() > 0) {
                // Rechercher l'indice de la carte de controle
                int indiceCarte = this.getIndiceControle(Integer.parseInt(numeroCarteCtrl));
                if (indiceCarte < 0) {
                    this.afficherReponse("Numéro de carte de contrôle incorrect.");
                    return;
                }
                if (carteConditionMentionnee) {
                    // Carte de contrôle + carte condition (+ indice condition si conditionMentionnee=true)
                    this.controlerLaCarteCondition(cc, indiceCarte, conditionMentionnee);
                } else {
                    // Carte de contrôle seule (indique toutes les cartes Condition qu'elle peut vérifier)
                    this.trouverLesConditionsPourCetteCarteControle(Integer.parseInt(numeroCarteCtrl));
                }
            } else {
                this.afficherReponse("Numéro de carte de contrôle non renseigné.");
            }
        }
    }

    // Rechercher toutes les cartes conditions qui concordent avec cette carte de contrôle
    private void trouverLesConditionsPourCetteCarteControle(int numeroCarteControle) {
        int indiceCarte = this.getIndiceControle(numeroCarteControle);
        if (indiceCarte >= 0) {
            this.controlerLaCarteDeControle(indiceCarte);
            return;
        }
        this.afficherReponse("Numéro de carte de contrôle introuvable.");
    }

    // Trouver l'indice de la carte de contrôle qui comporte ce numero sur l'un de ses côtés.
    // Retourne -1 si non trouvé
    private int getIndiceControle(int numeroCarteControle) {
        return this.listeCartesControle.getIndexByColor(numeroCarteControle);
    }

    // Trouver toutes les cartes condition qui fonctionnent avec cette carte de controle
    private void controlerLaCarteDeControle(int indiceCarteControle) {
        int numCarteCondition = this.listeCC.length;
        while (numCarteCondition > 0) {
            numCarteCondition--;
            CarteCondition cc = this.listeCC[numCarteCondition];
            this.controlerLaCarteCondition(cc,indiceCarteControle,false);
        }
    }

    // Trouver toutes les cartes de controle qui fonctionnent avec cette carte condition
    // indiceCarteCtrl : mettre this.listeControl.length pour controler toutes les cartes de controle,
    //                   mettre l'indice d'une carte controle pour ne verifier qu'elle
    private void controlerLaCarteCondition(CarteCondition cc, int indiceCarteCtrl, boolean conditionMentionnee) {
        StringBuilder texteReponse = new StringBuilder();
        // Tester toutes les conditions de cette carte
        int numeroDeLaCondition = cc.getNbConditions();
        while (numeroDeLaCondition > 0) {
            numeroDeLaCondition--;
            if (conditionMentionnee) {
                numeroDeLaCondition = cc.getCondition();
            } else {
                cc.setCondition(numeroDeLaCondition);
            }
            // Trouver quelles combinaisons peuvent correspondre a cette condition
            TotaliteDesCombinaisons listeCombinaisons = new TotaliteDesCombinaisons();
            listeCombinaisons.trouverToutesLesCombinaisons(cc);
            // Trouver des cartes de controle qui retournent les memes combinaisons avec les cartes perforees
            int numCtrl = this.listeCartesControle.getNbCartes();
            if (indiceCarteCtrl < numCtrl) {
                // Ne verifier qu'une seule carte controle
                if (listeCombinaisons.isControleOK(this.listeCartesControle.getCardByIndex(indiceCarteCtrl), this.listeCartesPerforees)) {
                    //texteReponse += "Condition "+cc.getCondition()+"."+numeroDeLaCondition+this.controlerConditionEtCcarteControle(listeCombinaisons,cc,listeControl[indiceCarteCtrl]);
                    texteReponse.append("Le contrôleur ").append(this.listeCartesControle.getCardByIndex(indiceCarteCtrl).getNumeros()).append(" peut être utilisé avec la carte ").append(cc.getNumCarte()).append(".\n");
                }
                else { Log.d("** KO **","pour la condition "+numeroDeLaCondition+" de la carte "+cc.getNumCarte()); }
            } else {
                // Verifier toutes les cartes de controle pour cette condition
                while (numCtrl > 0) {
                    numCtrl--;
                    if (listeCombinaisons.isControleOK(this.listeCartesControle.getCardByIndex(numCtrl), this.listeCartesPerforees)) {
                        texteReponse.append("Le contrôleur ").append(this.listeCartesControle.getCardByIndex(numCtrl).getNumeros()).append(" peut être utilisé avec la carte ").append(cc.getNumCarte()).append(".\n");
                    }
                    else { Log.d("*** KO ***","pour la condition "+numeroDeLaCondition+" de la carte "+cc.getNumCarte()); }
                }
            }
            if (conditionMentionnee) {
                // On ne devait contrôler qu'une seule condition. => On peut sortir du while.
                break;
            }
        }
        if (texteReponse.length() == 0) {
            texteReponse = new StringBuilder("Aucune solution.");
        }
        this.afficherReponse(texteReponse.toString());
    }
/*
    private String controlerConditionEtCcarteControle(TotaliteDesCombinaisons listeCombinaisons, CarteCondition cc, MatriceControler mc) {
        String texteReponse = "";
        if (listeCombinaisons.isControleOK(mc, this.listeCartesPerforees)) {
            texteReponse += "Le contrôleur "+mc.getNumeros()+" peut verifier la condition "+cc.getCondition()
                    +" de la carte "+cc.getNumCarte()+".\n";
        }
        return texteReponse;
    }
*/
    // Verifie toutes les combinaisons avec tous les controleurs selon toutes les cartes condition
    /*
    private void toutVerifier() {
        // Pour chaque carte, faire une verification par condition
        int numCarteCondition = this.listeCC.length;
        while (numCarteCondition > 0) {
            numCarteCondition--;
            CarteCondition cc = this.listeCC[numCarteCondition];
            this.controlerLaCarteCondition(cc,this.listeControl.length,false);
        }
    }
    */


}