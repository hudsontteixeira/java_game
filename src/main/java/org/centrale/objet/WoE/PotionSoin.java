package org.centrale.objet.WoE;

public class PotionSoin extends Objet{
    private int ptRevit;

    public PotionSoin(Point2D pos, int ptRevit) {
        super(pos);
        this.ptRevit = ptRevit;
    }
}
