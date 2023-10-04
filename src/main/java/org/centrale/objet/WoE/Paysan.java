package org.centrale.objet.WoE;
/**
 * Classe de création de Paysan
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Paysan extends Personnage{
    /**
     * Constructeur d'un paysan avec tous ses caracteristiques
     * @param nom donne un nom au Paysan
     * @param ptVie fixe une valeur initial de points de vie du Paysan
     * @param degAtt définit une valeur d'attaque pour le Paysan qui affectera les points de vie de l'adversaire
     * @param ptPar définit une valeur de points défendus pour un Paysan lorsqu'il est attaqué par un adversaire
     * @param pageAtt définit une valeur représentant la probabilité que le Paysan effectue une attaque
     * @param pagePar définit une valeur représentant la probabilité que le Paysan effectue une défense
     * @param distAttMax définit la distance maximale autorisée pour une attaque à distance
     * @param pos définit la position du personnage dans l'espace
     */
    public Paysan(String nom, int ptVie, int degAtt, int pageAtt, int ptPar, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, pageAtt, ptPar, pagePar, distAttMax, pos);
    }

    /**
     * Constructeur d'un paysan en copie d'un personnage
     * @param perso personnage à être copié
     * @param distAttMax distance de attaque maximale
     */
    public Paysan(Personnage perso, int distAttMax) {
        super(perso, distAttMax);
    }

    /**
     * Constructeur d'un Paysan par default
     */
    public Paysan(){
    }

}
