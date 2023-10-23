package org.centrale.objet.WoE;

import java.util.Random;
/**
 * Classe de création de Guerrier
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Guerrier extends Personnage implements Combattant {
    /**
     * COnstructeur d'un Guerrier
     * @param nom donne un nom au Guerrier
     * @param ptVie fixe une valeur initial de points de vie du Guerrier
     * @param degAtt définit une valeur d'attaque pour le Guerrier qui affectera les points de vie de l'adversaire
     * @param pageAtt définit une valeur représentant la probabilité que le Guerrier effectue une attaque
     * @param ptPar définit une valeur de points défendus pour un Guerrier lorsqu'il est attaqué par un adversaire
     * @param pagePar définit une valeur représentant la probabilité que le Guerrier effectue une défense
     * @param distAttMax définit la distance maximale autorisée pour une attaque à distance
     * @param pos définit la position du Guerrier dans l'espace
     */
    public Guerrier(String nom, int ptVie, int degAtt, int pageAtt, int ptPar, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, pageAtt, ptPar, pagePar, distAttMax, pos);
    }

    /**
     * Constucteur d'un Guerrier par default
     */
    public Guerrier(){
    }

    /**
     * Fonction de combattre corps à corps avec une créature
     * @param C  c'est la creature avec on va avoir un combatt
     */
    public void combattre(Creature C, Matrix monde){
        //using 1.414 as racine 2
        if(this.getPos().distance(C.getPos())<=1.43){
            //Dee Attaque
            Random deeAtk = new Random();
            int numberdeeAtk = deeAtk.nextInt(100) +1;
            //Dee Defense
            Random deeDef = new Random();
            int numberdeeDef = deeDef.nextInt(100) +1;

            //Contact
            if(numberdeeAtk <= this.getPageAtt()){
                // reussi
                if(numberdeeDef <= C.getPagePar()){
                    //Défense
                    C.setPtVie(C.getPtVie()-this.getDegAtt());
                    C.setPtVie(C.getPtVie()+C.getPtPar());
                    System.out.println(C.getNom() + " a reussi la defense et reste avec PtVie:" + C.getPtVie());
                    if(C.getPtVie()<0){
                            C.setPtVie(0);
                            monde.setPositionMatrix(C.getPos(),null);
                            C = null;
                        }

                } else{
                    //Sans Défense
                    C.setPtVie(C.getPtVie()-this.getDegAtt());
                    System.out.println(C.getNom() + " reste avec PtVie:" + C.getPtVie());
                    if(C.getPtVie()<0){
                        C.setPtVie(0);
                        monde.setPositionMatrix(C.getPos(),null);
                        C = null;

                    }
                }
            } else{
                System.out.println(this.getNom()+" a échoue l'attaque");
            }
        }
        else{
            System.out.println(this.getNom()+" n'est pas proche de son opponent");
        }
    }
}
