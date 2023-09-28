package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;

public class World {
    ArrayList<Personnage> personnages;
    public World(){

    }
    public void creerMondeAlea(){
        Archer robin = new Archer();
        Paysan paysan = new Paysan();
        Lapin lapin1 = new Lapin();
        Lapin lapin2 = new Lapin();
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
                points.add(new Point2D(random.nextInt(), random.nextInt()));
        }
        robin.setPos(points.get(0));
        paysan.setPos(points.get(1));
        lapin1.setPos(points.get(2));
        lapin2.setPos(points.get(3));

        System.out.println(robin.getPos().toString());
        System.out.println(paysan.getPos().toString());
        System.out.println(lapin1.getPos().toString());
        System.out.println(lapin2.getPos().toString());
    }
}
