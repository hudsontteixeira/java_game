package org.centrale.objet.WoE;

import java.util.Random;

public class Creature {
    private String nom;
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    public Creature(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }
    public Creature(Creature creat) {
        this.nom = creat.nom;
        this.ptVie = creat.ptVie;
        this.degAtt = creat.degAtt;
        this.ptPar = creat.ptPar;
        this.pageAtt = creat.pageAtt;
        this.pagePar = creat.pagePar;
        this.pos = new Point2D(creat.pos);
    }
    public Creature() {}
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos recois une objet Point2D pour assigner comme position
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     *
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

    public void affiche() {
        System.out.println("["+pos.x+";"+pos.y+"]");
    }

}
