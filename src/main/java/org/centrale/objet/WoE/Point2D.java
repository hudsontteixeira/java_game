package org.centrale.objet.WoE;
/**
 * Classe de création de Point 2D
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Point2D{
    int x;
    int y;
    //Creation  de points avec des atributs

    /**
     * constructeur d'un point 2d avec la position defaul (0,0)
     */
  public Point2D() {
      x=0;
      y=0;
  }

    /**
     * Constructeur d'un point 2d
     * @param e1 la position en x
     * @param e2 la position en y
     */
  public Point2D(int e1, int e2) {
        x=e1;
        y=e2;
  }

    /**
     * Setter pour changer la position x
     * @param e1 position x à être changé
     */

    // Methode setX
    public void setX(int e1) {
        x = e1;
    }
    // Methode getX
    /**
     * Getter pour la position x
     * @return position x demandé
     */
    public int getX() {
        return x;
    }
    /**
     * Setter pour changer la position y
     * @param e2 position y à être changé
     */
    // Methode setY
    public void setY(int e2) {
        y = e2;
    }
    // Methode getY
    /**
     * Getter pour la position y
     * @return position y demandé
     */
    public int getY() {
        return y;
    }
    //Constructeur de recopie

    /**
     * Constructeur de recopie
     * @param point point à être copie
     */
    public Point2D(Point2D point) {
        x = point.x;
        y = point.y;
    }
    //Affichage des coordonées

    /**
     * Methòde pour afficher les points
     */
    public void affiche() {
        System.out.println("["+x+";"+y+"]");
    }

    /**
     * Methòde pour ajouter des valeurs dans un point donné
     * @param dX valeur à incrementer à la variable x
     * @param dY valeur à incrementer à la variable y
     */
    public void translate (int dX, int dY){
        x = (x+dX);
        y = (y+dY);
    }

    /**
     * Setter pour changer la position x et y d'un point
     * @param e1 la position en x
     * @param e2 la position en y
     */
    public void setPosition (int e1, int e2){
        x = e1;
        y = e2;
    }
    // Methode distance

    /**
     * Methòde pour calculer la distance entre 2 points
     * @param point point à calculer la distance
     * @return une valeur grâce à la formule de distance entre 2 points
     */
    public double distance(Point2D point) {
      return Math.sqrt(Math.pow((this.x-point.x),2)+Math.pow((this.y-point.y),2));
    }

    /**
     * Methòde pour definition des points en string
     * @return une string que décrit le point
     */
    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

