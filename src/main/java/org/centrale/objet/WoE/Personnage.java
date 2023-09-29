package org.centrale.objet.WoE;

import java.util.Random;

public class Personnage extends Creature {
    /**
     * @autor LOPEZ TEIXEIRA
     */
    private int distAttMax;

    /**
     *
     * @param nom variable pour definir un nom au personnage
     * @param ptVie variable pour definir une quantité de points de vie au personnage
     * @param degAtt variable pour definir le valeur du dégât lors combat
     * @param ptPar variable pour definir la quantité de points défendus lors d'une attaque
     * @param pageAtt write
     * @param pagePar write
     * @param distAttMax write
     * @param pos write
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom,ptVie,degAtt,ptPar,pageAtt,pagePar,pos);
        this.distAttMax = distAttMax;
    }
    public Personnage(Personnage perso) {
        super(perso);
    }

    public Personnage(Personnage perso, int distAttMax) {
        super(perso);
        this.distAttMax = distAttMax;
    }

    /**
     *
     */
    public Personnage() {
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    // Methode distance
    public double distance(Point2D point) {
        return Math.sqrt(Math.pow((super.getPos().x-point.x),2)+Math.pow((super.getPos().y-point.y),2));
    }
}
