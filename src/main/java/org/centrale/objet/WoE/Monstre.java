package org.centrale.objet.WoE;

import java.util.Random;
/**
 * Classe de création de Monstres
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Monstre extends Creature{
    /**
     * Créer un nouveau Monstre
     * @param nom donne un nom au Monstre
     * @param ptVie fixe une valeur initial de points de vie du Monstre
     * @param degAtt définit une valeur d'attaque pour le Monstre qui affectera les points de vie de l'adversaire
     * @param ptPar définit une valeur de points défendus pour un monstre lorsqu'il est attaqué par un adversaire
     * @param pageAtt définit une valeur représentant la probabilité que le monstre effectue une attaque
     * @param pagePar définit une valeur représentant la probabilité que le monstre effectue une défense
     * @param pos définit la position du personnage dans l'espace
     */
    public Monstre(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    /**
     * Cloner un monstre créé
     * @param monstre Monstre à cloner
     */
    public Monstre(Monstre monstre) {
        super(monstre);
    }

    /**
     *  Créer un Personage default
     */
    public Monstre() {
    }


}
