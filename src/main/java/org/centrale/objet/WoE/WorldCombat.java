package org.centrale.objet.WoE;

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
        grosBill = new Guerrier("grossBill",100,20,30,20,30,0,new Point2D(13,9));
        wolfie = new Loup("Wolfie1",100,20,10,70,80,new Point2D(12,9));
        wolfie2 = new Loup("Wolfie2",100,20,10,70,80,new Point2D(0,0));
        //Set Bug Position (12,9)
        bug1 = new Lapin("lapin1",100,0,20,0,80,new Point2D(12,9));
        bug2 = new Lapin("lapin2",100,0,20,0,80,new Point2D(40,40));

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





    }

}
