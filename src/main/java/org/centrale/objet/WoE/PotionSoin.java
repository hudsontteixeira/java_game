package org.centrale.objet.WoE;
/**
 * Classe de création d'une potion'
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class PotionSoin extends Objet implements Utilisable {
    private int ptRevit;
    private int uses;
    /**
     * Constructeur pour une potion
     * @param pos position donnée d'objet
     * @param ptRevit points de vie d'un personnage à augmenter
     */
    public PotionSoin(Point2D pos, int ptRevit) {
        super(pos);
        this.ptRevit = ptRevit;
        uses = 3;
    }
    public PotionSoin(Point2D pos, int ptRevit, int uses) {
        super(pos);
        this.ptRevit = ptRevit;
        this.uses = uses;
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

    @Override
    public void decrementer() {
        uses-=1;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
