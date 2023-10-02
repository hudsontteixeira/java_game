package org.centrale.objet.WoE;

import java.util.Random;

public class Guerrier extends Personnage {
    public Guerrier(String nom, int ptVie, int degAtt, int pageAtt, int ptPar, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, pageAtt, ptPar, pagePar, distAttMax, pos);
    }

    public Guerrier(Personnage perso, int distAttMax) {
        super(perso, distAttMax);
    }

    public Guerrier(){
    }

    public void combattre(Creature C){
        if(this.getPos().distance(C.getPos())==1){
            //Dee Attaque
            Random deeAtk = new Random();
            int numberdeeAtk = deeAtk.nextInt(100) +1;
            //Dee Defense
            Random deeDef = new Random();
            int numberdeeDef = deeDef.nextInt(100) +1;

            //Contact
            if(numberdeeAtk <= this.getPageAtt()){
                // reussi
                if(numberdeeDef <= C.getPagePar()){
                    //Défense
                    C.setPtVie(C.getPtVie()-this.getDegAtt());
                    C.setPtVie(C.getPtVie()+C.getPtPar());
                        if(C.getPtVie()<0){
                            C.setPtVie(0);
                        }
                    System.out.println(C.getNom() + " a reussi la defense et reste avec PtVie:" + C.getPtVie());

                } else{
                    //Sans Défense
                    C.setPtVie(C.getPtVie()-this.getDegAtt());
                    if(C.getPtVie()<0){
                        C.setPtVie(0);
                    }
                    System.out.println(C.getNom() + " reste avec PtVie:" + C.getPtVie());
                }
            } else{
                System.out.println(this.getNom()+" a échoue l'attaque");
            }
        }
        else{
            System.out.println(this.getNom()+" n'est pas proche de son opponent");
        }
    }
}
