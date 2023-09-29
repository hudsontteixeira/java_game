package org.centrale.objet.WoE;

import java.util.Random;

public class Personnage {
    private String nom;
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    private Point2D pos;

    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.distAttMax = distAttMax;
        this.pos = pos;
    }

    public Personnage(Personnage perso) {
        this.nom = perso.nom;
        this.ptVie = perso.ptVie;
        this.degAtt = perso.degAtt;
        this.ptPar = perso.ptPar;
        this.pageAtt = perso.pageAtt;
        this.pagePar = perso.pagePar;
        this.distAttMax = perso.distAttMax;
        this.pos = perso.pos;
    }

    public Personnage() {

    }

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

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void deplace() {
        Random random1 = new Random();
        Random random2 = new Random();
        int numberRdnx = random1.nextInt(2 + 1) - 1;
        int numberRdny = random2.nextInt(2 + 1) - 1;
        pos.translate(numberRdnx,numberRdny);
    }
}
