

package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
/**
 * Classe de création de Personnages
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Personnage extends Creature {

    private int distAttMax;


    /**
     * Créer un nouveau Personnage
     * @param nom donne un nom au Personnage
     * @param ptVie fixe une valeur initial de points de vie du Personnage
     * @param degAtt définit une valeur d'attaque pour le Personnage qui affectera les points de vie de l'adversaire
     * @param ptPar définit une valeur de points défendus pour un Personnage lorsqu'il est attaqué par un adversaire
     * @param pageAtt définit une valeur représentant la probabilité que le Personnage effectue une attaque
     * @param pagePar définit une valeur représentant la probabilité que le Personnage effectue une défense
     * @param distAttMax définit la distance maximale autorisée pour une attaque à distance
     * @param pos définit la position du personnage dans l'espace
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom,ptVie,degAtt,ptPar,pageAtt,pagePar,pos);
        this.distAttMax = distAttMax;
    }

    /**
     * Clone un Personnage créé
     * @param perso  Personnage à cloner
     */
    public Personnage(Personnage perso) {
        super(perso);
    }

    /**
     * Créer un Personage et choisir ça distance de attaque
     * @param perso Personnage à cloner
     * @param distAttMax Distance maximum du Personnage
     */
    public Personnage(Personnage perso, int distAttMax) {
        super(perso);
        this.distAttMax = distAttMax;
    }

    /**
     *Créer un Personage default
     */
    public Personnage() {
    }

    /**
     * Nous donne la Distance de Attaque Maximale
     * @return distance d'attaque
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * Change la Distance de Attaque Maximale
     * @param distAttMax Distance maximum du Personnage
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * Fonction d'interaction avec l'objet
     * @param objet objet avec lequel le personnage interagira
     */
    public void utiliserObjet(Objet objet){
            //check if object is close
        if(objet instanceof Utilisable) {
                if (objet instanceof Epee) {
                    Epee sword = (Epee) objet;
                    this.setDegAtt(this.getDegAtt() + (sword.getPtdegat()));
                    objet = null;

                }
                if (objet instanceof PotionSoin) {
                    //check if warior is hurt
                    if (this.getPtVie() < 100) {
                        PotionSoin potion = (PotionSoin) objet;
                        this.setPtVie(this.getPtVie() + (potion.getPtRevit()));
                        System.out.println(this.getNom() + " a " + this.getPtVie() + "pt vie");

                        if (this.getPtVie() > 100) {
                            this.setPtVie(100);
                        }
                        objet = null;
                    } else {
                        System.out.println("vous êtes déjà Guerri et peut pas prendre la potion");
                    }
                }

        }
        }




}
