package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class World {
    ArrayList<Creature> creatures;
    ArrayList<Objet> objets;
    Archer guillaumeT;
    Archer robin;
    Lapin bugs1;
    Lapin bugs2;
    Paysan peon;
    Guerrier grosBill;
    Loup wolfie;
    int taille;
    Matrix espaceMatrix;


    public void creerMatrixPosition(){
        taille = 6;
        espaceMatrix = new Matrix(new int[taille][taille]);
        Archer robin1 = new Archer("robin1",100,20,10,80,40,20,new Point2D(0,0),3);
        Archer robin2 = new Archer("robin2",100,20,10,80,40,20,new Point2D(5,5),3);
        Archer robin3 = new Archer("robin3",100,20,10,80,40,20,new Point2D(1,1),3);
        Archer robin4 = new Archer("robin3",100,20,10,80,40,20,new Point2D(1,2),3);
        Archer robin5 = new Archer("robin3",100,20,10,80,40,20,new Point2D(2,2),3);
        Archer robin6 = new Archer("robin3",100,20,10,80,40,20,new Point2D(3,3),3);
        Archer robin7 = new Archer("robin3",100,20,10,80,40,20,new Point2D(4,4),3);

        espaceMatrix.setPositionMatrix(robin1.getPos(),1);
        espaceMatrix.setPositionMatrix(robin2.getPos(),1);
        espaceMatrix.setPositionMatrix(robin3.getPos(),1);
        espaceMatrix.setPositionMatrix(robin4.getPos(),1);

        robin4.deplace(espaceMatrix);
        robin4.deplace(espaceMatrix);
        robin4.deplace(espaceMatrix);
        robin4.deplace(espaceMatrix);
        robin4.deplace(espaceMatrix);
        robin4.deplace(espaceMatrix);
        robin4.deplace(espaceMatrix);
        robin4.deplace(espaceMatrix);
        robin4.deplace(espaceMatrix);
    }



    /**
     * @autor LOPEZ TEIXEIRA
     */
    public World() {
        this.creatures = new ArrayList<Creature>();
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
        peon.deplace(espaceMatrix);
        System.out.println("Deplacement1 Paysan "+peon.getPos().toString());
        peon.deplace(espaceMatrix);
        System.out.println("Deplacement2 Paysan "+peon.getPos().toString());
        peon.deplace(espaceMatrix);
        System.out.println("Deplacement3 Paysan "+peon.getPos().toString());
        peon.deplace(espaceMatrix);
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
        robin.deplace(espaceMatrix);

        System.out.println("Guillaume: ");
        guillaumeT.affiche();
        System.out.println("Robin: ");
        robin.affiche();

        double distRobPeon = new Double(robin.getPos().distance(peon.getPos()));

        System.out.println("Dist Robin et peon: "+distRobPeon);

    }
    public void creerMondeAleaCollections(){
        taille = 50;
        Random random = new Random();
        //int nbArcher =  random.nextInt(20) + 1;
        //int nbPaysan =  random.nextInt(20) + 1;
        //int nbLapin =  random.nextInt(20) + 1;
        //int nbGuerrier =  random.nextInt(20) + 1;
        //int nbLoup =  random.nextInt(20) + 1;

        int nbArcher =  2000;
        int nbPaysan =  2000;
        int nbLapin =  2000;
        int nbGuerrier =  2000;
        int nbLoup =  2000;

        /*
        CREATION DE CREATURES
        * */

        for (int i = 0; i < nbArcher; i++) {
            creatures.add(new Archer(" ", random.nextInt(100), 0, 0, 0, 0, 0, new Point2D(), 0));
        }
        for (int i = 0; i < nbPaysan; i++) {
            creatures.add(new Paysan(" ", random.nextInt(100), 0, 0, 0, 0, 0, new Point2D()));
        }
        for (int i = 0; i < nbLapin; i++) {
            creatures.add(new Paysan(" ", random.nextInt(100), 0, 0, 0, 0, 0, new Point2D()));
        }
        for (int i = 0; i < nbGuerrier; i++) {
            creatures.add(new Guerrier(" ", random.nextInt(100), 0, 0, 0, 0, 0, new Point2D()));
        }
        for (int i = 0; i < nbLoup; i++) {
            creatures.add(new Loup(" ", random.nextInt(100), 0, 0, 0, 0, new Point2D()));
        }

        //CREATION DE POINTS
        ArrayList<Point2D> points = new ArrayList<>();
        boolean  different = true;
        while(points.size()<creatures.size()){
            Point2D point = new Point2D(random.nextInt(taille), random.nextInt(taille));
            different = true;
            for(Point2D p: points){
                if(p.x == point.x && p.y == point.y){
                    different = false;
                    break;
                }
            }
            if(different)
                points.add(point);
            break;
        }

        System.out.println(points.size());
        System.out.println(creatures.size());

        //for (int i=0; i<creatures.size(); i++){
        //    creatures.get(i).setPos(points.get(i));
        //}

        /*
        ARRAYLIST PREUVE SIZE
        * */

        //int TotalVie = 0;
        //long timeB = System.nanoTime();
        //for (int i=0; i<creatures.size(); i++){
        //    TotalVie+=creatures.get(i).getPtVie();
        //}
        //long timeE = System.nanoTime();
        //System.out.print("Temp Arraylist; ");
        //System.out.println(timeE-timeB);
        //System.out.println(TotalVie);

        LinkedList listaCreatures = new LinkedList(creatures);
        LinkedList<Creature> linkedList = listaCreatures;

        /*
        LINKEDLIST PREUVE SIZE
        * */
        int TotalVie2 = 0;
        long timeD = System.nanoTime();
        for (int i=0; i<listaCreatures.size(); i++){
            TotalVie2+=(linkedList.get(i)).getPtVie();
        }

        long timeF = System.nanoTime();
        System.out.print("Temp LinkedList; ");
        System.out.println(timeF-timeD);
        System.out.println(TotalVie2);


        /*
        ARRAYLIST PREUVE ITERATOR
        * */
        int TotalVie3 = 0;
        long timeB2 = System.nanoTime();
        for (Creature c:
             creatures) {
            TotalVie3+=c.getPtVie();
        }
        long timeE2 = System.nanoTime();
        System.out.print("Temp Arraylist ITERATOR; ");
        System.out.println(timeE2-timeB2);
        System.out.println(TotalVie3);

        /*
        LINKEDLIST PREUVE ITERATOR
        * */
        int TotalVie4 = 0;
        long timeG = System.nanoTime();
        for (Creature c:
                linkedList) {
            TotalVie4+=c.getPtVie();
        }

        long timeH = System.nanoTime();
        System.out.print("Temp LinkedList ITERATOR; ");
        System.out.println(timeH-timeG);
        System.out.println(TotalVie4);
    }

    public void creerMondeDeplacementPasOcuppee(){
        creerMatrixPosition();
    }
    public void tourDeJeu(){

    }
    public void afficheWorld(){

    }
}
