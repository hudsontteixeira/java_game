package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class Joueur {
    public Personnage perso;
    private ArrayList<Utilisable> effets;
    private ArrayList<Utilisable> inventaire;
    public Joueur(Personnage perso) {
        if(perso instanceof Guerrier || perso instanceof Archer ){
            this.perso = perso;
        } else {
            System.out.println("choisissez un personnage valabe");
        }

    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    public Joueur(){
        this.perso = new Personnage();
    };
    public void choosePersonnage(){

        Scanner sc = new Scanner(System.in);
        String typep;
        do {
            System.out.println("Choisir un type de personnage (Archer/Guerrier)");
            typep = sc.nextLine();
        }while(!typep.equals("Guerrier") && !typep.equals("Archer"));

        System.out.println("Choisir un nom");
        String persoNom = sc.nextLine();

        Random random = new Random();
        //creation archer avec moins de points de attaque mais plus de precision
        int numberdegattArch = random.nextInt(20 - 10) + 10; //max 20 min 10 faible attaque
        int numberpagattArch = random.nextInt(100 - 60) + 60; //max 100 min 60 bones chances de reussis (precision)
        int numberptparArch = random.nextInt(15 - 1) + 1; //max 15 min 1
        int numberpageparArch = random.nextInt(40 - 10) + 10; //max 10 min 1 faible chance de defense
        int numberdistArch = random.nextInt(20 - 10) + 10; //max 20 min 10 max
        int numberflArch = random.nextInt(50 - 10) + 10; //max 50 min 10 max
        Point2D point = new Point2D(random.nextInt(3),random.nextInt(3)); //Quelque  point d'une matrice 100X100
        inventaire = new ArrayList<>();
        //creation archer avec plus de points de attaque mais plus de precision
        int numberdegattWarrior = random.nextInt(40 - 20) + 20; //max 40 min 20 fort attaque
        int numberpagattWarrior = random.nextInt(80 - 20) + 20; //max 80 min 20 moyennes chances de reussis (precision)
        int numberptparWarrior = random.nextInt(20 - 10) + 1; //max 20 min 10
        int numberpageparWarrior = random.nextInt(70 - 50) + 50; //max 70 min 50 bonne chance de defense
        if(typep.equals("Guerrier")){
            Guerrier war = new Guerrier(persoNom,100,numberdegattWarrior,numberpagattWarrior,numberptparWarrior,numberpageparWarrior,0,point);
            this.perso = war;
        }
        if(typep.equals("Archer")){
            Archer arc =  new Archer(persoNom,100,numberdegattArch,numberptparArch,numberpagattArch,numberpageparArch,numberdistArch,point,numberflArch);
            this.perso = arc;
        }
    }

    public void deplace(Matrix monde,String awsd) {
        int numberx=0;
        int numbery=0;
        if(awsd.equals("a")){
            numberx=0;
            numbery=-1;
        } else if (awsd.equals("s")) {
            numberx=1;
            numbery=0;
        } else if (awsd.equals("d")) {
            numberx=0;
            numbery=1;
        } else if (awsd.equals("w")) {
            numberx=-1;
            numbery=0;
        }
        if(monde.getPositionMatrix(new Point2D(this.perso.getPos().getX()+numberx,this.perso.getPos().getY()+numbery))==null){
            monde.setPositionMatrix(this.perso.getPos(), null);
            this.perso.getPos().translate(numberx, numbery);
            monde.setPositionMatrix(this.perso.getPos(), this.perso);

        }else if (monde.getPositionMatrix(new Point2D(this.perso.getPos().getX()+numberx,this.perso.getPos().getY()+numbery)) instanceof Utilisable){
            this.inventaire.add((Utilisable) monde.getPositionMatrix(new Point2D(this.perso.getPos().getX()+numberx,this.perso.getPos().getY()+numbery)));
            perso.prendObjet((Objet)monde.getPositionMatrix(new Point2D(this.perso.getPos().getX()+numberx,this.perso.getPos().getY()+numbery)),monde);

            monde.setPositionMatrix(this.perso.getPos(), null);

            this.perso.getPos().translate(numberx, numbery);
            monde.setPositionMatrix(this.perso.getPos(), this.perso);

        }else{
            System.out.println("Peut pas y aller");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            this.deplace(monde,option);
        }
    }


    public void setInventaire(ArrayList<Utilisable> inventaire) {
        this.inventaire = inventaire;
    }

    public void addToInventaire(Utilisable obj){
        this.inventaire.add(obj);
    }

    public ArrayList<Utilisable> getInventaire() {
        return inventaire;
    }

    public ArrayList<Utilisable> getEffets() {
        return effets;
    }

    public void setEffets(ArrayList<Utilisable> effets) {
        this.effets = effets;
    }
}
