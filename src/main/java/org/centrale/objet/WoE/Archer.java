package org.centrale.objet.WoE;

import java.util.Random;
/**
 * Classe de création d' Archer
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Archer extends Personnage {
    private int nbFleches;

    /**
     * Constructeur Archer
     * @param nom donne un nom au Archer
     * @param pV fixe une valeur initial de points de vie du Archer
     * @param dA définit une valeur d'attaque pour le Archer qui affectera les points de vie de l'adversaire
     * @param pPar définit une valeur de points défendus pour un Archer lorsqu'il est attaqué par un adversaire
     * @param paAtt définit une valeur représentant la probabilité que le Archer effectue une attaque
     * @param paPar définit une valeur représentant la probabilité que le Archer effectue une défense
     * @param dMax définit la distance maximale autorisée pour une attaque à distance
     * @param p définit la position du personnage dans l'espace
     * @param nbFleches  définit le nombre de flèches d'Archer
     */
    public Archer(String nom, int pV, int dA, int pPar, int paAtt,int paPar, int dMax,Point2D p,int nbFleches){
    super(nom,pV,dA, pPar, paAtt,paPar,dMax,p);
    this.nbFleches = nbFleches;
    }

    /**
     * Constructeur de Archer en prennant un Personnage
     * @param perso Definit personnge à cloner
     * @param distAttMax définit la distance maximale autorisée pour une attaque à distance
     * @param nbFleches définit le nombre de flèches d'Archer
     */
    public Archer(Personnage perso, int distAttMax, int nbFleches) {
        super(perso, distAttMax);
        this.nbFleches = nbFleches;
    }

    /**
     *  Créer un personnage juste avec le nombre de flèches
     * @param nbFleches Definit personnge à cloner
     */
    public Archer(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Methòde pour prendre le nombre de flèches disponible
     * @return nombre de flèches disponible
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     * Methòde pour changer le nombre de flèches disponible
     * @param nbFleches nombre de flèches à changer
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Constructeur d'un Archer Default
     */
    public Archer(){
    }

    /**
     * Fonction de combattre à distance avec une créature
     * @param C c'est la creature avec on va avoir un combatt
     */
    public void combattre(Creature C){
        //Dee Attaque
        Random deeAtk = new Random();
        int numberdeeAtk = deeAtk.nextInt(100) +1;
        //Distance Atack
            if(this.getPos().distance(C.getPos())<this.getDistAttMax() && this.getNbFleches() > 0){
                this.setNbFleches(this.getNbFleches()-1);
                System.out.println(this.getNom()+" a un total de " + this.getNbFleches()+ " flèches");
                if(numberdeeAtk <= this.getPageAtt()){
                    // reussi
                        //Sans Défense
                        C.setPtVie(C.getPtVie()-this.getDegAtt());
                            if(C.getPtVie()<0){
                                C.setPtVie(0);
                            }
                        System.out.println(C.getNom() + "PtVie:" + C.getPtVie());
                } else{
                    System.out.println(this.getNom()+" a échoue l'attaque");
                }
            } else {
                if(this.getNbFleches() == 0) {
                    System.out.println(this.getNom() + " n'a plus de flèches");
                } else{
                    System.out.println(this.getNom() + " est très loin du objectif");
                }
            }
    }

}
