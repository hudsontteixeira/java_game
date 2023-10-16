package org.centrale.objet.WoE;

import java.util.Random;

public class NuageToxique extends Objet implements Deplacable,Combattant {
    private int DegAtt;
    public NuageToxique(Point2D point) {
        super(point);
    }

    public NuageToxique(Objet objet) {
        super(objet);
    }

    public NuageToxique(){}

    public int getDegAtt() {
        return DegAtt;
    }

    public void setDegAtt(int degAtt) {
        DegAtt = degAtt;
    }

    /**
     * Methòde pour changer la position de une creature dans le monde sans chevauchement.
     * @param monde monde avec les tailles e contraints definit
     */
    @Override
    public void deplace(Matrix monde) {
        Random random1 = new Random();
        Random random2 = new Random();
        int numberRdnx = random1.nextInt( 3) - 1;
        int numberRdny = random2.nextInt() - 1;
        while (monde.getPositionMatrix(new Point2D(this.getPos().getX()+numberRdnx,this.getPos().getY()+numberRdny))!=null){
            random1 = new Random();
            random2 = new Random();
            numberRdnx = random1.nextInt(3 ) - 1;
            numberRdny = random2.nextInt(3 ) - 1;
        }
        Point2D pointTest = new Point2D(this.getPos().getX()+numberRdnx,this.getPos().getY()+numberRdny);
        if(monde.getPositionMatrix(pointTest)==null&&pointTest.getX()>=0&&pointTest.getX()<=monde.getEspaceMatrix()[0].length&&pointTest.getY()>=0&&pointTest.getY()<=monde.getEspaceMatrix()[0].length){
            monde.setPositionMatrix(this.getPos(), null);
            this.getPos().translate(numberRdnx, numberRdny);
            monde.setPositionMatrix(this.getPos(), this);

        }
    }
    /**
     * Fonction de combattre corps à corps avec une créature
     * @param C  c'est la creature avec on va avoir un combatt
     */
    @Override

    public void combattre(Creature C, Matrix monde){
        //using 1.414 as racine 2
        if(this.getPos().distance(C.getPos())<=1.414){
                    //Sans Défense
                    C.setPtVie(C.getPtVie()-this.getDegAtt());
                    System.out.println(C.getNom() + "reste avec PtVie:" + C.getPtVie() + "À cause de Nuage toxique ");
                    if(C.getPtVie()<0){
                        C.setPtVie(0);
                        monde.setPositionMatrix(C.getPos(),null);
                        C = null;
                    }
                }

    }


}
