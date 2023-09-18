package org.centrale.objet.WoE;

public class Lapin extends Monstre {
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar,Point2D p){
        super(pV,dA,pPar,paAtt,paPar,p);
    }
    public Lapin(Lapin l){
        super((Monstre)l);
    }

    public Lapin(){

    }
}
