package org.centrale.objet.WoE;

public class Archer extends Personnage {
    private int nbFleches;
    public Archer(String nom, int pV, int dA, int pPar, int paAtt,int paPar, int dMax,Point2D p,int nbFleches){
    super(nom,pV,dA, pPar, paAtt,paPar,dMax,p);
    this.nbFleches = nbFleches;
    }

    public Archer(Archer a){
        super((Personnage)a);
        this.nbFleches = a.nbFleches;
    }

    public Archer(){
    }
}
