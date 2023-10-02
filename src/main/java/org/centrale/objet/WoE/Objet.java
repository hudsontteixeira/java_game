package org.centrale.objet.WoE;

public class Objet {
    private Point2D pos;

    public Objet(Point2D pos) {
        this.pos = pos;
    }

    public Objet(Objet objet) {
        this.pos = new Point2D();
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
}
