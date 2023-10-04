package org.centrale.objet.WoE;
/**
 * Classe de création d'un Matrice Monde
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Matrix {
    private int[][] espaceMatrix;

    /**
     * Getter pour une matrice d'espace
     * @return la matrice d'espace
     */
    public int[][] getEspaceMatrix() {
        return espaceMatrix;
    }

    /**
     * Constructeur de notre matrice du monde
     * @param espaceMatrix matrice du monde
     */
    public Matrix(int[][] espaceMatrix) {
        this.espaceMatrix = espaceMatrix;
    }

    /**
     * Methóde pour changer la matrice du monde
     * @param espaceMatrix matrice du monde à changer
     */
    public void setEspaceMatrix(int[][] espaceMatrix) {
        this.espaceMatrix = espaceMatrix;
    }

    /**
     * Methòde pour savoir si une espace est libre (0) ou non dans une matrice (1)
     * @param point point de localisation dans la matrice
     * @return 1 si est occupé, 0 si non
     */
    public int getPositionMatrix(Point2D point) {
        if(point.getX()>=0&&point.getY()>=0&&point.getX()<this.espaceMatrix[0].length&&point.getY()<this.espaceMatrix.length){
            return espaceMatrix[point.getX()][point.getY()];
        } else{
            return 1;
        }
    }

    /**
     * ethòde pour changer dans la matrice si une espace est libre (0) ou non (1)
     * @param point point a changer
     * @param etat nouveau etat, 0 ou 1
     */
    public void setPositionMatrix(Point2D point,int etat){
            if(point.getX()>=0&&point.getY()>=0&&point.getX()<=this.espaceMatrix[0].length&&point.getY()<=this.espaceMatrix.length){
                espaceMatrix [point.getX()][point.getY()] = etat;
            } else{
                System.out.println("Out of borders");
            }
    }

    /**
     * Methòde qui affiche notre matrice de monde dans le console
     */
    public void affiche(){

        for (int i = 0; i < this.espaceMatrix.length; i++) {
            for (int j = 0; j < this.espaceMatrix[i].length; j++) {
                System.out.print(this.espaceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
