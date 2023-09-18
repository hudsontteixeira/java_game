package org.centrale.objet.WoE;

public class Paysan extends Personnage{

    public Paysan(String nom, int ptVie, int degAtt, int pageAtt, int ptPar, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, pageAtt, ptPar, pagePar, distAttMax, pos);
    }
    public Paysan(Paysan p){
        super((Personnage)p);
    }
    public Paysan(){

    }

}
