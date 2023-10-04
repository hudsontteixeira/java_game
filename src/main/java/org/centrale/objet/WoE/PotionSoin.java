package org.centrale.objet.WoE;
/**
 * Classe de création d'une potion'
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class PotionSoin extends Objet{
    private int ptRevit;
    /**
     * Constructeur pour une potion
     * @param pos position donnée d'objet
     * @param ptRevit points de vie d'un personnage à augmenter
     */
    public PotionSoin(Point2D pos, int ptRevit) {
        super(pos);
        this.ptRevit = ptRevit;
    }
    /**
     * Getter pour prendre valeur de vie à augmenter
     * @return  valeur de vie à augmenter
     */

    public int getPtRevit() {
        return ptRevit;
    }

    /**
     * Setter pour changer valeur de vie à augmenter dans un personnage
     * @param ptRevit nouveau points de vie d'un personnage à augmenter
     */
    public void setPtRevit(int ptRevit) {
        this.ptRevit = ptRevit;
    }
}
