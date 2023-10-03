package org.centrale.objet.WoE;

public class Matrix {
    private int[][] espaceMatrix;

    public int[][] getEspaceMatrix() {
        return espaceMatrix;
    }

    public Matrix(int[][] espaceMatrix) {
        this.espaceMatrix = espaceMatrix;
    }

    public void setEspaceMatrix(int[][] espaceMatrix) {
        this.espaceMatrix = espaceMatrix;
    }

    public int getPositionMatrix(Point2D point) {
        if(point.getX()>=0&&point.getY()>=0&&point.getX()<this.espaceMatrix[0].length&&point.getY()<this.espaceMatrix.length){
            return espaceMatrix[point.getX()][point.getY()];
        } else{
            return 1;
        }
    }

    public void setPositionMatrix(Point2D point,int etat){
            if(point.getX()>=0&&point.getY()>=0&&point.getX()<=this.espaceMatrix[0].length&&point.getY()<=this.espaceMatrix.length){
                espaceMatrix [point.getX()][point.getY()] = etat;
            } else{
                System.out.println("Out of borders");
            }
    }

    public void affiche(){

        for (int i = 0; i < this.espaceMatrix.length; i++) {
            for (int j = 0; j < this.espaceMatrix[i].length; j++) {
                System.out.print(this.espaceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
