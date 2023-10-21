package org.centrale.objet.WoE;
/**
 * Classe de création d'un Matrice Monde
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Matrix {
    private ElementDeJeu[][] espaceMatrix;

    /**
     * Getter pour une matrice d'espace
     * @return la matrice d'espace
     */
    public ElementDeJeu[][] getEspaceMatrix() {
        return espaceMatrix;
    }

    /**
     * Constructeur de notre matrice du monde
     * @param espaceMatrix matrice du monde
     */
    public Matrix(ElementDeJeu[][] espaceMatrix) {
        this.espaceMatrix = espaceMatrix;
    }

    /**
     * Methóde pour changer la matrice du monde
     * @param espaceMatrix matrice du monde à changer
     */
    public void setEspaceMatrix(ElementDeJeu[][] espaceMatrix) {
        this.espaceMatrix = espaceMatrix;
    }

    /**
     * Methòde pour savoir si une espace est libre (0) ou non dans une matrice (1)
     * @param point point de localisation dans la matrice
     * @return ElementDeJeu
     */
    public ElementDeJeu getPositionMatrix(Point2D point) {
        if(point.getX()>=0&&point.getY()>=0&&point.getX()<this.espaceMatrix[0].length&&point.getY()<this.espaceMatrix.length){
            return espaceMatrix[point.getX()][point.getY()]; //object in the place
        } else{
            return null;
        }
    }

    /**
     * ethòde pour changer dans la matrice si une espace est libre (0) ou non (1)
     * @param point point a changer
     * @param elem nouveau etat, ElementDeJeu OU NULL
     */
    public void setPositionMatrix(Point2D point, ElementDeJeu elem){
            if(point.getX()>=0&&point.getY()>=0&&point.getX()<=this.espaceMatrix[0].length&&point.getY()<=this.espaceMatrix.length){
                espaceMatrix [point.getX()][point.getY()] = elem;
            } else{
                System.out.println("Out of borders");
            }
    }
    /**
     * Methòde qui affiche notre matrice de monde dans le console
     */
    public void affiche(Joueur jouer, ElementDeJeu opponent){
        String valueShow = "0";
        for (int i = 0; i < this.espaceMatrix.length*2+1; i++)
            System.out.print("_");
        System.out.println();
        for (int i = 0; i < this.espaceMatrix.length; i++) {
            System.out.print(Integer.toString(i)+' ');
            for (int j = 0; j < this.espaceMatrix[i].length; j++) {
                if(this.espaceMatrix[i][j] != null){
                    valueShow = this.espaceMatrix[i][j].getClass().getSimpleName().substring(0,1);
                }
                else {
                    valueShow = ".";
                }
                if(jouer != null && i==jouer.perso.getPos().getX()&& j==jouer.perso.getPos().getY()) {
                    System.out.print("\u001B[34m"+jouer.perso.getNom().substring(0,1)+"\u001B[0m" + " ");

                } else if (((Creature)opponent) != null && i==((Creature)opponent).getPos().getX()&& j==((Creature)opponent).getPos().getY()) {
                    System.out.print("\u001B[31m"+valueShow+"\u001B[0m" + " ");

                } else if(this.espaceMatrix[i][j] instanceof Objet){

                    if((Objet)this.espaceMatrix[i][j] instanceof NuageToxique){
                        System.out.print("\u001B[35m"+"N"+"\u001B[0m" + " ");
                    }else if((Objet)this.espaceMatrix[i][j] instanceof PotionSoin){
                        System.out.print("\u001B[36m"+"P"+"\u001B[0m" + " ");
                    }else if((Objet)this.espaceMatrix[i][j] instanceof Epee){
                        System.out.print("\u001B[36m"+"E"+"\u001B[0m" + " ");
                    };

                } else {
                    System.out.print(valueShow + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
