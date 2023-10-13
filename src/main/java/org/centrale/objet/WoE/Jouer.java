package org.centrale.objet.WoE;

import java.util.Random;
import java.util.Scanner;

public class Jouer {
    public Personnage perso;

    public Jouer(Personnage perso) {
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

    public Jouer(){
        this.perso = new Personnage();
    };
    public void choosePersonnage(){
        System.out.println("Choisir un type de personnage (Archer/Guerrier)");
        Scanner sc = new Scanner(System.in);
        String persoClass = sc.nextLine();
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
        Point2D point = new Point2D(random.nextInt(100),random.nextInt(100)); //Quelque  point d'une matrice 100X100

        //creation archer avec moins de points de attaque mais plus de precision
        int numberdegattWarrior = random.nextInt(40 - 20) + 20; //max 40 min 20 fort attaque
        int numberpagattWarrior = random.nextInt(80 - 20) + 20; //max 80 min 20 moyennes chances de reussis (precision)
        int numberptparWarrior = random.nextInt(20 - 10) + 1; //max 20 min 10
        int numberpageparWarrior = random.nextInt(70 - 50) + 50; //max 70 min 50 bonne chance de defense
        if(persoClass.equals("Guerrier")){
            Guerrier war = new Guerrier(persoNom,100,numberdegattWarrior,numberpagattWarrior,numberptparWarrior,numberpageparWarrior,0,point);
            this.perso = war;
        }
        if(persoClass.equals("Archer")){
            Archer arc =  new Archer(persoNom,100,numberdegattArch,numberptparArch,numberpagattArch,numberpageparArch,numberdistArch,point,numberflArch);
            this.perso = arc;
        }
    }
}