package org.centrale.objet.WoE;

import java.util.Random;

public class Archer extends Personnage {
    private int nbFleches;

    public Archer(String nom, int pV, int dA, int pPar, int paAtt,int paPar, int dMax,Point2D p,int nbFleches){
    super(nom,pV,dA, pPar, paAtt,paPar,dMax,p);
    this.nbFleches = nbFleches;
    }

    public Archer(Personnage perso, int distAttMax, int nbFleches) {
        super(perso, distAttMax);
        this.nbFleches = nbFleches;
    }

    public Archer(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    public Archer(){
    }

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
