

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
    public void prendObjet(Objet objet){
            //check if object is close
            if (this.getPos().distance(objet.getPos()) == 0) {
                if (objet instanceof Epee) {
                    Epee sword = (Epee) objet;
                    this.setDegAtt(this.getDegAtt() + (sword.getPtdegat()));
                    objet = null;
                }
                if (objet instanceof PotionSoin) {
                    //check if warior is hurt
                    if(this.getPtVie()<100) {
                    PotionSoin potion = (PotionSoin) objet;
                    this.setPtVie(this.getPtVie() + (potion.getPtRevit()));
                        if(this.getPtVie()>100) {this.setPtVie(100);}
                        objet = null;
                    } else{
                        System.out.println("vous êtes déjÀ Guerri et peut pas prendre la potion");
                    }
                }
            } else {
                System.out.println("vous êtes loin d'objet");
            }
        }


}
