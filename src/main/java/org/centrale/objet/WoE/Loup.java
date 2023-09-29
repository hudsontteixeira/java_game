package org.centrale.objet.WoE;

public class Loup extends Monstre{
    public Loup(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Loup(Creature creat) {
        super(creat);
    }

    public Loup() {
    }
}
