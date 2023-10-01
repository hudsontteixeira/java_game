package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

public class World {
    ArrayList<Personnage> personnages;
    Archer guillaumeT;
    Archer robin;
    Lapin bugs1;
    Lapin bugs2;
    Paysan peon;
    Guerrier grosBill;
    Loup wolfie;
    /**
     * @autor LOPEZ TEIXEIRA
     */
    public World(){

    }

    /**
     *
     */
    public void creerMondeAlea(){
        robin = new Archer();
        peon = new Paysan();
        bugs1 = new Lapin();
        bugs2 = new Lapin();
        Random random = new Random();
        ArrayList<Point2D> points = new ArrayList<>();
        boolean  different = true;
        for (int i = 0; i<5; i++) {
            Point2D point = new Point2D(random.nextInt(), random.nextInt());
            for(Point2D p: points){
                if(p.x == point.x && p.y == point.y){
                    different = false;
                    break;
                }
            }
            if(different)
                points.add(point);
        }
        robin.setPos(points.get(0));
        peon.setPos(points.get(1));
        bugs1.setPos(points.get(2));
        bugs2.setPos(points.get(3));
        System.out.println("Début Robin "+robin.getPos().toString());
        System.out.println("Début Paysan "+peon.getPos().toString());
        peon.deplace();
        System.out.println("Deplacement1 Paysan "+peon.getPos().toString());
        peon.deplace();
        System.out.println("Deplacement2 Paysan "+peon.getPos().toString());
        peon.deplace();
        System.out.println("Deplacement3 Paysan "+peon.getPos().toString());
        peon.deplace();
        System.out.println("Deplacement4 Paysan "+peon.getPos().toString());
        System.out.println("Début Lapin1 ");
        bugs1.affiche();
        System.out.println("Début Lapin2 ");
        bugs2.affiche();

        /*
        Copie d’objet
        * */
        System.out.println("Robin: ");
        robin.affiche();
        guillaumeT = new Archer(robin,0,0);
        guillaumeT.affiche();

        System.out.println("Deplacement...");
        robin.deplace();

        System.out.println("Guillaume: ");
        guillaumeT.affiche();
        System.out.println("Robin: ");
        robin.affiche();
        double distRobPeon = new Double(robin.getPos().distance(peon.getPos()));

        System.out.println("Dist Robin et peon: "+distRobPeon);

    }

    public void tourDeJeu(){

    }
    public void afficheWorld(){

    }
}
