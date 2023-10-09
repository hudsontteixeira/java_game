package org.centrale.objet.WoE;

import java.util.Random;
/**
 * Classe de création de Loup
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Loup extends Monstre implements Combattant{
    /**
     *
     * Créer un nouveau Loup
     * @param nom donne un nom au loup
     * @param ptVie fixe une valeur initial de points de vie du Loup
     * @param degAtt définit une valeur d'attaque pour Loup qui affectera les points de vie de l'adversaire
     * @param ptPar définit une valeur de points défendus pour un Loup lorsqu'il est attaqué par un adversaire
     * @param pageAtt définit une valeur représentant la probabilité que le loup effectue une attaque
     * @param pagePar définit une valeur représentant la probabilité que le loup effectue une défense
     * @param pos définit la position du loup dans l'espace
     */
    public Loup(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    /**
     * Créer un loup a partir d'un monstre
     * @param monstre monstre á être clone
     */
    public Loup(Monstre monstre) {
        super(monstre);
    }

    /**
     * Créer une loup par default
     */
    public Loup() {
    }
    /**
     * Fonction de combattre corps à corps avec une créature
     * @param C  c'est la creature avec on va avoir un combatt
     */
    public void combattre(Creature C){
        if(this.getPos().distance(C.getPos())==1){
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
                    if(C.getPtVie()<0){
                        C.setPtVie(0);
                    }
                    System.out.println(C.getNom() + " a reussi la defense et reste avec PtVie:" + C.getPtVie());

                } else{
                    //Sans Défense
                    C.setPtVie(C.getPtVie()-this.getDegAtt());
                    if(C.getPtVie()<0){
                        C.setPtVie(0);
                    }
                    System.out.println(C.getNom() + " reste avec PtVie:" + C.getPtVie());
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
