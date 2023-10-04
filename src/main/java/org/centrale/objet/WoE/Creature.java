package org.centrale.objet.WoE;

import java.util.Random;
/**
 * Classe de création de creatures
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Creature {
    private String nom;
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    /**
     * Constructeur d'une Creature
     * @param nom nom donne un nom a la Creature
     * @param ptVie fixe une valeur initial de points de vie de la Creature
     * @param degAtt  définit une valeur d'attaque pour la Creature qui affectera les points de vie de l'adversaire
     * @param ptPar définit une valeur de points défendus pour une Creature lorsqu'il est attaqué par un adversaire
     * @param pageAtt définit une valeur représentant la probabilité que la Creature effectue une attaque
     * @param pagePar définit une valeur représentant la probabilité que la Creature effectue une défense
     * @param pos définit la position de la Creature dans l'espace
     */
    public Creature(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }

    /**
     * Constructeur qui clonne une creature
     * @param creat c'est la créature à clonner
     */
    public Creature(Creature creat) {
        this.nom = creat.nom;
        this.ptVie = creat.ptVie;
        this.degAtt = creat.degAtt;
        this.ptPar = creat.ptPar;
        this.pageAtt = creat.pageAtt;
        this.pagePar = creat.pagePar;
        this.pos = new Point2D(creat.pos);
    }

    /**
     * Constructeur pour créer une creature par default
     */
    public Creature() {}

    /**
     * Getter pour le nom de la creature
     * @return nom de la creature
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter pour changer le nom de la creature
     * @param nom  nom de la creature à changer
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter pour prendre les points de vie de la creature
     * @return nom de la creature
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *  Setter pour changer les points de vie de la creature
     * @param ptVie points de vie de la creature à changer
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     * Getter pour prendre les valeurs de degat de la creature
     * @return points de vie
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * Setter pour changer les valeurs de degat de la creature
     * @param degAtt points de degat
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * Getter pour prendre les points de vie de la creature
     * @return points de deffence pendant combatt
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * Setter pour  changer les points defendus pour une creature pendant un attaque
     * @param ptPar les points defendus à changer
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Getter pour prendre la probabilite de reussité pendant un attaque, valeur plus grand plus de chance de reussir
     * @return Probabilité de reussité d'attaque
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     * Setter pour la probabilite de reussité pendant un attaque,
     * @param pageAtt Probabilité de reussité d'attaque à changer
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     * Getter pour prendre la probabilite de reussir une deffense pendant un attaque, valeur plus grand plus de chance de reussir
     * @return Probabilité de reussité une défense
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     * Setter pour changer la probabilite de reussir une deffense pendant un attaque
     * @param pagePar  valeur de probabilité de reussité une défense à changer
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     * Getter pour prendre un point d'une creature
     * @return position de la creature
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * setter pour changer un point d'une creature
     * @param pos recois une objet Point2D pour assigner comme position
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Methòde pour changer la position de une creature n'importe où.
     */
    public void deplaceAncien() {
        Random random1 = new Random();
        Random random2 = new Random();
        int numberRdnx = random1.nextInt(2 + 1) - 1;
        int numberRdny = random2.nextInt(2 + 1) - 1;
        pos.translate(numberRdnx,numberRdny);
    }

    /**
     * Methòde pour changer la position de une creature dans le monde sans chevauchement.
     * @param monde monde avec les tailles e contraints definit
     */
    public void deplace(Matrix monde) {
        Random random1 = new Random();
        Random random2 = new Random();
        int numberRdnx = random1.nextInt(2 + 1) - 1;
        int numberRdny = random2.nextInt(2 + 1) - 1;
        while (monde.getPositionMatrix(new Point2D(pos.getX()+numberRdnx,pos.getY()+numberRdny))==1){
            random1 = new Random();
            random2 = new Random();
            numberRdnx = random1.nextInt(2 + 1) - 1;
            numberRdny = random2.nextInt(2 + 1) - 1;
        }
        if(monde.getPositionMatrix(new Point2D(pos.getX()+numberRdnx,pos.getY()+numberRdny))==0){
                monde.setPositionMatrix(pos, 0);
                pos.translate(numberRdnx, numberRdny);
                monde.setPositionMatrix(pos, 1);

        }
    }

    /**
     * Methòde pour montrer la position X,Y dans le monde
     */
    public void affiche() {
        System.out.println("["+pos.x+";"+pos.y+"]");
    }

}
