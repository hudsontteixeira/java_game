package org.centrale.objet.WoE;

public class Lapin extends Monstre {
    public Lapin(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Lapin(Monstre monstre) {
        super(monstre);
    }

    public Lapin(Lapin l){
        super(l);
    }

    public Lapin(){

    }
}
