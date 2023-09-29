package org.centrale.objet.WoE;

public class Guerrier extends Personnage {
    public Guerrier(String nom, int ptVie, int degAtt, int pageAtt, int ptPar, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, pageAtt, ptPar, pagePar, distAttMax, pos);
    }

    public Guerrier(Personnage perso, int distAttMax) {
        super(perso, distAttMax);
    }

    public Guerrier(){
    }
}
