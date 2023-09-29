package org.centrale.objet.WoE;

import java.util.Random;

public class Monstre extends Creature{

    public Monstre(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Monstre(Creature creat) {
        super(creat);
    }

    public Monstre() {
    }


}
