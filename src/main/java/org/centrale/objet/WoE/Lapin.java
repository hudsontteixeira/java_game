package org.centrale.objet.WoE;
/**
 * Classe de création de Lapin
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Lapin extends Monstre {
    /**
     * Créer un nouveau Lapin
     * @param nom donne un nom au Lapin
     * @param ptVie fixe une valeur initial de points de vie du Lapin
     * @param degAtt définit une valeur d'attaque pour le Lapin qui affectera les points de vie de l'adversaire
     * @param ptPar définit une valeur de points défendus pour un lapin lorsqu'il est attaqué par un adversaire
     * @param pageAtt définit une valeur représentant la probabilité que le lapin effectue une attaque
     * @param pagePar définit une valeur représentant la probabilité que le lapin effectue une défense
     * @param pos définit la position du lapin dans l'espace
     */
    public Lapin(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    /**
     * Constructor pour faire une copie d'un Lapin avec un monstre
     * @param monstre monstre À se developper en lapin
     */
    public Lapin(Monstre monstre) {
        super(monstre);
    }

    /**
     * Constructeur pour copie d'un lapin
     * @param l
     */
    public Lapin(Lapin l){
        super(l);
    }

    /**
     * Constructeur d'un lapin par default
     */
    public Lapin(){

    }
}
