package org.centrale.objet.WoE;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class WorldCombat {
    ArrayList<Personnage> personnages;
    Archer guillaumeT;
    Archer robin;
    Lapin bug1;
    Lapin bug2;
    Paysan peon;
    Guerrier grosBill;
    Loup wolfie;
    Loup wolfie2;
    PotionSoin possionMagic;
    Epee sword;

    /**
     * @autor LOPEZ TEIXEIRA
     */
    public WorldCombat(){

    }

    /**
     *
     */
    public void creerCombatMondeAlea(){
        //Set Robin 3 flèches Position (0,0)
        robin = new Archer("robin",100,20,10,80,40,20,new Point2D(0,0),3);
        grosBill = new Guerrier("grossBill",100,20,10,20,30,0,new Point2D(13,9));
        wolfie = new Loup("Wolfie1",100,20,10,70,80,new Point2D(12,9));
        wolfie2 = new Loup("Wolfie2",100,20,10,70,80,new Point2D(0,0));
        //Set Bug Position (12,9)
        bug1 = new Lapin("lapin1",100,0,20,0,80,new Point2D(12,9));
        bug2 = new Lapin("lapin2",100,0,20,0,80,new Point2D(40,40));
        possionMagic = new PotionSoin(new Point2D(11,11),10);
        sword = new Epee(new Point2D(10,10),10);
        System.out.println("Simulation Archer Toue une Bug que c'est dans une dist < 20");
        robin.combattre(bug1);
        robin.combattre(bug1);
        robin.combattre(bug1);
        robin.combattre(bug1);
        System.out.println("Simulation Archer Toue une Bug que c'est dans une dist > 20");
        robin.setNbFleches(1);
        robin.combattre(bug2);
        System.out.println("Simulation Guerrier Toue une Loup dist=1");
        grosBill.combattre(wolfie);
        wolfie.combattre(grosBill);
        grosBill.combattre(wolfie);
        wolfie.combattre(grosBill);
        grosBill.combattre(wolfie);
        wolfie.combattre(grosBill);
        System.out.println("Simulation Guerrier Toue une Loup dist!=1");
        grosBill.combattre(wolfie2);
        System.out.println("Guerrier prend potion loin");
        grosBill.prendObjet(possionMagic);
        System.out.println("Guerrier prend potion bonne place");
        grosBill.setPos(new Point2D(11,11));
        grosBill.prendObjet(possionMagic);
        System.out.println("Guerrier prend Epee loin");
        grosBill.prendObjet(sword);
        System.out.println("Guerrier prend Epee bonne place");
        grosBill.setPos(new Point2D(10,10));
        grosBill.prendObjet(sword);







    }

}
