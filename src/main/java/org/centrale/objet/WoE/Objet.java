package org.centrale.objet.WoE;
/**
 * Classe de création d'un Objet
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Objet {

    private Point2D pos;

    /**
     * Constructeur d'un Objet
     * @param pos position d'objet
     */
    public Objet(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Constructeur de copie d'objet
     * @param objet objet à être clonne
     */
    public Objet(Objet objet) {
        this.pos = new Point2D();
    }

    /**
     * Methòde pour prendre la position d'objet
     * @return la position d'objet (un point Point2D)
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Methòde pour changer la position d'objet
     * @param pos a position d'objet à changer (un point Point2D)
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
}
