package org.centrale.objet.WoE;

public class Point2D{
    int x;
    int y;
    //Creation  de points avec des atributs
  public Point2D() {
      x=0;
      y=0;
  }
  public Point2D(int e1, int e2) {
        x=e1;
        y=e2;
  }

    // Methode setX
    public void setX(int e1) {
        x = e1;
    }
    // Methode getX
    public int getX() {
        return x;
    }
    // Methode setY
    public void setY(int e2) {
        y = e2;
    }
    // Methode getY
    public int getY() {
        return y;
    }
    //Constructeur de recopie
    public Point2D(Point2D point) {
        x = point.x;
        y = point.y;
    }
    //Affichage des coordonées

    public void affiche() {
        System.out.println("["+x+";"+y+"]");
    }
    public void translate (int dX, int dY){
        x = (x+dX);
        y = (y+dY);
    }

    public void setPosition (int e1, int e2){
        x = e1;
        y = e2;
    }
    // Methode distance
    public double distance(Point2D point) {
      return Math.sqrt(Math.pow((this.x-point.x),2)+Math.pow((this.y-point.y),2));
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

