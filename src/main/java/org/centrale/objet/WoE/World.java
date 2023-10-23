package org.centrale.objet.WoE;
import java.io.*;
import java.util.*;
/**
 * Classe de création du Monde
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class World {

    Joueur player1 = new Joueur();
    ArrayList<Creature> creatures;
    ArrayList<ElementDeJeu> eleJeu;
    ArrayList<Objet> objets;
    Archer guillaumeT;
    Archer robin;
    Lapin bugs1;
    Lapin bugs2;
    Lapin bug1;
    Lapin bug2;
    Paysan peon;
    Guerrier grosBill;
    Loup wolfie;
    Loup wolfie2;
    PotionSoin possionMagic;
    Epee sword;
    int taille = 0 ;
    Matrix espaceMatrix;

    /**
     * Fonction que demande une option de jeu pour commencer
     */
    public void startGame(){
        System.out.println("1. Bienvenue dans WoE : Pour tester un monde aléatoire appuyez 1,") ;
        System.out.println("2. Pour générer un monde de combat (TP2)\n3. Pour tester un monde avec de grandes collections et tester leurs performances appuyez 3,");
        System.out.println("4. Pour générer un monde où les personnages ne peuvent pas se chevaucher appuyez (TP3) 4.");
        System.out.println("5. Pour regarder des exceptions (TP4) 5.");
        System.out.println("6. Pour atribuire un personnage jouable à un jouer et puis garder appuyez (TP5)");
        System.out.println("7. Pour charger la dernière sauvegarde (TP6)");
        Scanner sc = new Scanner(System.in);
        int startOption = sc.nextInt();
        switch (startOption) {
            case 1:
                this.creerMondeAlea();
                break;
            case 2:
                this.creerCombatMondeAlea();
                break;
            case 3:
                this.creerMondeAleaCollections();
                break;
            case 4:
                this.creerMatrixPosition();
                break;
            case 5:
                this.creerCombatMondeAleaException();
                break;
            case 6:
                this.creerCombatJuable();
                break;
            case 7:
                this.lireMonde();
                break;
            default:
                // Código a ejecutar si startOption no coincide con ningún caso
        }
    }

    /**
     * Constructeur pour créer un monde default avec un liste de créatures
     */
    public World() {
        this.creatures = new ArrayList<Creature>();
        this.eleJeu = new ArrayList<ElementDeJeu>();

    }

    /**
     * Fonction pour créer un monde avec quelques creatures pour essaier les fonctions de deplacement des différents créatures
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
        peon.deplaceAncien();
        System.out.println("Deplacement1 Paysan "+peon.getPos().toString());
        peon.deplaceAncien();
        System.out.println("Deplacement2 Paysan "+peon.getPos().toString());
        peon.deplaceAncien();
        System.out.println("Deplacement3 Paysan "+peon.getPos().toString());
        peon.deplaceAncien();
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
        System.out.println("Guillaume: ");
        guillaumeT = new Archer(robin,0,0);
        guillaumeT.affiche();

        System.out.println("Deplacement...");
        robin.deplaceAncien();

        System.out.println("Guillaume: ");
        guillaumeT.affiche();
        System.out.println("Robin: ");
        robin.affiche();

        double distRobPeon = new Double(robin.getPos().distance(peon.getPos()));

        System.out.println("Dist Robin et peon: "+distRobPeon);

    }

    /**
     * Fonction pour créer un monde avec une simulation de combattre entre 6 créatures
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
        robin.combattre(bug1,espaceMatrix);
        robin.combattre(bug1,espaceMatrix);
        robin.combattre(bug1,espaceMatrix);
        robin.combattre(bug1,espaceMatrix);
        System.out.println("Simulation Archer Toue une Bug que c'est dans une dist > 20");
        robin.setNbFleches(1);
        robin.combattre(bug2,espaceMatrix);
        System.out.println("Simulation Guerrier Toue une Loup dist=1");
        grosBill.combattre(wolfie,espaceMatrix);
        wolfie.combattre(grosBill,espaceMatrix);
        grosBill.combattre(wolfie,espaceMatrix);
        wolfie.combattre(grosBill,espaceMatrix);
        grosBill.combattre(wolfie,espaceMatrix);
        wolfie.combattre(grosBill,espaceMatrix);
        System.out.println("Simulation Guerrier Toue une Loup dist!=1");
        grosBill.combattre(wolfie2,espaceMatrix);
        System.out.println("Guerrier essaie prendre potion loin");;
        System.out.println("Guerrier essaie prendre potion bonne place");
        grosBill.setPos(new Point2D(11,11));;
        System.out.println("Guerrier ptVie:"+grosBill.getPtVie());
        System.out.println("Guerrier essaie prendre Epee loin");
        System.out.println("Guerrier essaie prendre Epee bonne place");
        System.out.println("Guerrier degat avant:"+grosBill.getDegAtt());
        grosBill.setPos(new Point2D(10,10));
        System.out.println("Guerrier degat:"+grosBill.getDegAtt());


    }

    /**
     * Fonction pour créer un monde avec plusieurs personnages pour faire des essaies de performance
     */
    public void creerMondeAleaCollections(){
        taille = 60;
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

    /**
     * Fonction qui ajoute des elements de jeu À notre jeu du TP5/TP6.
     */
    public void AddAleaCollections(){
        Random random = new Random();
        //creation archer avec moins de points de attaque mais plus de precision
        int numberdegattArch = random.nextInt(20 - 10) + 10; //max 20 min 10 faible attaque
        int numberpagattArch = random.nextInt(100 - 60) + 60; //max 100 min 60 bones chances de reussis (precision)
        int numberptparArch = random.nextInt(15 - 1) + 1; //max 15 min 1
        int numberpageparArch = random.nextInt(40 - 10) + 10; //max 10 min 1 faible chance de defense
        int numberdistArch = random.nextInt(20 - 10) + 10; //max 20 min 10 max
        int numberflArch = random.nextInt(50 - 10) + 10; //max 50 min 10 max

        //creation archer avec plus de points de attaque mais plus de precision
        int numberdegattWarrior = random.nextInt(40 - 20) + 20; //max 40 min 20 fort attaque
        int numberpagattWarrior = random.nextInt(80 - 20) + 20; //max 80 min 20 moyennes chances de reussis (precision)
        int numberptparWarrior = random.nextInt(20 - 10) + 1; //max 20 min 10
        int numberpageparWarrior = random.nextInt(70 - 50) + 50; //max 70 min 50 bonne chance de defense
         //set amount of opponents in the game for each class
        int nbArcher =  2;
        int nbPaysan =  2;
        int nbLapin =  2;
        int nbGuerrier =  2;
        int nbLoup =  1;

        /*
        CREATION D'ITENS
        * */

        for (int i = 0; i < nbArcher; i++) {
            eleJeu.add(new Archer("Arqueiro",100,numberdegattArch,numberptparArch,numberpagattArch,numberpageparArch,numberdistArch,new Point2D(),numberflArch));
        }
        for (int i = 0; i < nbPaysan; i++) {
            eleJeu.add(new Paysan("Paisano", 100, 0, 0, 0, 0, 0, new Point2D()));
        }
        for (int i = 0; i < nbLapin; i++) {
            eleJeu.add(new Lapin("Lapin",100,0,0,0,0,new Point2D()));
        }
        for (int i = 0; i < nbGuerrier; i++) {
            eleJeu.add(new Guerrier("Guerreiro",100,numberdegattWarrior,numberpagattWarrior,numberptparWarrior,numberpageparWarrior,0,new Point2D()));
        }
        for (int i = 0; i < nbLoup; i++) {
            eleJeu.add(new Loup("Loup", random.nextInt(100), 0, 0, 0, 0, new Point2D()));
        }
        eleJeu.add(new PotionSoin(new Point2D(random.nextInt(taille),random.nextInt(taille)),10));
        eleJeu.add(new PotionSoin(new Point2D(random.nextInt(taille),random.nextInt(taille)),10));

        //CREATION DE POINTS
        ArrayList<Point2D> points = new ArrayList<>();
        boolean  different = true;
        //points EleJeu
        while(points.size()<eleJeu.size()+1){
            Point2D point = new Point2D(random.nextInt(taille), random.nextInt(taille));
            different = true;
            for(Point2D p: points){
                if(p.x == point.x && p.y == point.y){
                    different = false;
                    break;
                }
            }
            if(different) {
                points.add(point);
            }
        }

        //points nuage
        int numberOfNuages = 1;
        ArrayList<Point2D> pointsNuage = new ArrayList<>();
        NuageToxique nuageToxique = new NuageToxique(new Point2D(0,5));

        for (int i=0; i<eleJeu.size(); i++){
            if(eleJeu.get(i) instanceof Creature) {
                ((Creature)eleJeu.get(i)).setPos(points.get(i));
            }
            if(eleJeu.get(i) instanceof Objet) {
                ((Objet)eleJeu.get(i)).setPos(points.get(i));
            }
           espaceMatrix.setPositionMatrix(points.get(i),eleJeu.get(i));
        }
        eleJeu.add(nuageToxique);
        espaceMatrix.setPositionMatrix(nuageToxique.getPos(),nuageToxique);

    }
    /**
     * Fonction permettant de créer un jeu avec une matrice qui stocke la position des créatures
     */
    public void creerMatrixPosition(){
        taille = 3;
        espaceMatrix = new Matrix(new ElementDeJeu[taille][taille]);
        Archer robin1 = new Archer("robin1",100,20,10,80,40,20,new Point2D(0,0),3);
        Archer robin2 = new Archer("robin2",100,20,10,80,40,20,new Point2D(0,1),3);
        Archer robin3 = new Archer("robin3",100,20,10,80,40,20,new Point2D(1,2),3);
        Archer robin4 = new Archer("robin3",100,20,10,80,40,20,new Point2D(1,1),3);

        espaceMatrix.setPositionMatrix(robin1.getPos(),robin1);
        espaceMatrix.setPositionMatrix(robin2.getPos(),robin2);
        espaceMatrix.setPositionMatrix(robin3.getPos(),robin3);
        espaceMatrix.setPositionMatrix(robin4.getPos(),robin4);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
        System.out.println();
        robin4.deplace(espaceMatrix);
        espaceMatrix.affiche(player1,null);
    }

    /**
     * Fonction pour démontrée la exception de StackOverFlow
     * @param arr array à être à ajouté des nouveaux objets jusq à l'infinie
     * @param i counter
     * @return error
     */
    public ArrayList<Nourriture> recursiveError(ArrayList<Nourriture>arr,int i){
        arr.add(new Nourriture(1,2));
        return recursiveError(arr,i + 2);
    }

    /**
     * Fonction pour démontrer dans la consle les exceptions JAVA
     */
    public void creerCombatMondeAleaException ()  {
        Archer nulo = null;

        /* NULL POINTER EXCEPTION */
        try{
        nulo.getPos();
        }catch(NullPointerException e){
            System.out.println("Exception trouvée: "+e.toString());
        }

        for (int i = 0; i < 3; i++) {
            creatures.add(new Archer(6));
        }

        /* INDEX OUT BOUNDS EXCEPTION */
        try {
            for (int i = 0; i < 4; i++) {
                creatures.get(i);
            }
        }catch(Exception e){
            System.out.println("Exception trouvée: "+e.toString());
        };

        /* ARITHMETIC EXCEPTION */
        try {
            int a = 1/0;
        }catch(ArithmeticException e){
            System.out.println("Exception trouvée: "+e.toString());
        };

        /* CLASSCAST EXCEPTION */
        try {
            Creature paisano = new Paysan();

            System.out.println(((Monstre)paisano));

        }catch(ClassCastException e){
            System.out.println("Exception trouvée: "+e.toString());
        };

        /* NUMBER FORMAT EXCEPTION */
        try {
            String mot = "Panadero";

            System.out.println(Integer.parseInt(mot));

        }catch(NumberFormatException e){
            System.out.println("Exception trouvée: "+e.toString());
        };

        /* StackOverflowError */
        int i = 0;
        ArrayList<Nourriture> foodList = new ArrayList<Nourriture>();
        try {
            ArrayList<Nourriture>arrError = recursiveError(foodList,i);
        } catch(StackOverflowError e){
            System.out.println("Exception trouvée: "+e.toString());
        };

        /*ConcurrentModificationException*/
        ArrayList<Nourriture> arr = new ArrayList<Nourriture>();
        arr.add(new Nourriture(1,2));
        arr.add(new Nourriture(2,2));
        arr.add(new Nourriture(3,2));
        arr.add(new Nourriture(4,2));
        arr.add(new Nourriture(5,2));


        try {
            // Loop
            for (Nourriture elem : arr) {
                if (elem.getTours()==2) {
                    arr.remove(elem); // exception.
                }
            }
        }
        catch (ConcurrentModificationException e) {
            System.out.println("Exception trouvée: "+e);
        }

    }

    /**
     * Fonction pour créer un Combat juable
     */
    public void creerCombatJuable(){

        Creature previousElemJeu = null;

        if(taille == 0){
            player1.choosePersonnage();
            Scanner sc = new Scanner(System.in);
            System.out.println("Digitez taille du monde (Supérieure à 5)");
            taille = sc.nextInt();
            espaceMatrix = new Matrix(new ElementDeJeu[taille][taille]);
            AddAleaCollections();
        }else{
            System.out.println("Chargement de jeu... ");
            espaceMatrix = new Matrix(new ElementDeJeu[taille][taille]);
            for (ElementDeJeu eleJeu:eleJeu
                 ) {
                if(eleJeu instanceof Creature){
                    espaceMatrix.setPositionMatrix(((Creature) eleJeu).getPos(),eleJeu);
                }
                if(eleJeu instanceof Objet) {
                    espaceMatrix.setPositionMatrix(((Objet) eleJeu).getPos(), eleJeu);
                }
            }
            espaceMatrix.setPositionMatrix(player1.perso.getPos(), player1.perso);
        }



        espaceMatrix.setPositionMatrix(player1.getPerso().getPos(),player1.perso);
        espaceMatrix.affiche(player1,null);

        while (player1.perso.getPtVie()>0) {
            tourDeJeu(player1,previousElemJeu,null);
            if (player1.perso.getPtVie() <= 0) {
                System.out.println("Fin de Jeu tu as perdu");
                break;
            }
        }

    }
    /**
     * Fonction pour définir le tour du jeu
     */
    public void tourDeJeu(Joueur jr, Creature previousElemJeu, String recursive){
        String option;
        Random random1 = new Random();
        if(recursive == null) {
                System.out.println("AWSD pour se deplacer \nQ pour attaquer, \nI pour ouvrir inventaire \nX Pour garder monde \nY Pour retourner");
                Scanner sc = new Scanner(System.in);
                option = sc.nextLine();
        } else {
                option = recursive;
        }


        switch (option) {
            case "a":
            case "w":
            case "s":
            case "d":
                jr.deplace(espaceMatrix, option);
                espaceMatrix.affiche(player1, null);
                previousElemJeu = null;
                break;
            case "q":
                int numberRdnx = random1.nextInt(1 + 1) - 1;
                int numberRdny = random1.nextInt(1 + 1) - 1;
                if (jr.perso instanceof Archer) {
                    numberRdnx = random1.nextInt(((jr.perso).getDistAttMax() - 1) + ((jr.perso).getDistAttMax() - 1)) - ((jr.perso).getDistAttMax() - 1);
                    numberRdny = random1.nextInt(((jr.perso).getDistAttMax() - 1) + ((jr.perso).getDistAttMax() - 1)) - ((jr.perso).getDistAttMax() - 1);
                }
                Point2D AtackPoint = new Point2D(jr.perso.getPos().getX() + numberRdnx, jr.perso.getPos().getX() + numberRdny);
                //start new fight
                if (previousElemJeu == null) {
                    if (espaceMatrix.getPositionMatrix(AtackPoint) != null && espaceMatrix.getPositionMatrix(AtackPoint) instanceof Creature) {
                        if (jr.perso instanceof Guerrier) {
                            Guerrier Warrior = (Guerrier) jr.perso;
                            Warrior.combattre((Creature) espaceMatrix.getPositionMatrix(AtackPoint), espaceMatrix);
                            previousElemJeu = (Creature) espaceMatrix.getPositionMatrix(AtackPoint);
                            if (previousElemJeu instanceof Loup) {
                                ((Loup) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                            else if (previousElemJeu instanceof Archer) {
                                ((Archer) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                            else if (previousElemJeu instanceof Guerrier) {
                                ((Guerrier) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                        }
                        if (jr.perso instanceof Archer) {
                            Archer Archer = (Archer) jr.perso;
                            Archer.combattre((Creature) espaceMatrix.getPositionMatrix(AtackPoint), espaceMatrix);
                            previousElemJeu = (Creature) espaceMatrix.getPositionMatrix(AtackPoint);
                            if (previousElemJeu instanceof Loup) {
                                ((Loup) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                            if (previousElemJeu instanceof Archer) {
                                ((Archer) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                            if (previousElemJeu instanceof Guerrier) {
                                ((Guerrier) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                        }
                    } else {
                        tourDeJeu(jr, previousElemJeu, "q");
                    }
                } else {
                    //Existent fight
                    if (previousElemJeu instanceof Creature) {
                        if (jr.perso instanceof Guerrier) {
                            Guerrier Warrior = (Guerrier) jr.perso;
                            Warrior.combattre(previousElemJeu, espaceMatrix);
                            if (previousElemJeu instanceof Loup) {
                                ((Loup) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                            if (previousElemJeu instanceof Archer) {
                                ((Archer) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                            if (previousElemJeu instanceof Guerrier) {
                                ((Guerrier) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                        }
                        if (jr.perso instanceof Archer) {
                            Archer Archer = (Archer) jr.perso;
                            Archer.combattre(previousElemJeu, espaceMatrix);
                            if (previousElemJeu instanceof Loup) {
                                ((Loup) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                            if (previousElemJeu instanceof Archer) {
                                ((Archer) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                            if (previousElemJeu instanceof Guerrier) {
                                ((Guerrier) previousElemJeu).combattre(jr.perso, espaceMatrix);
                            }
                        }
                        if (previousElemJeu.getPtVie() <= 0) {
                            previousElemJeu = null;
                        }
                    }
                }

                break;
            case "x":
                System.out.println("Choisissez un nom pour sauvegarder le match");
                Scanner scanSave = new Scanner(System.in);
                String nomSauvegarde = scanSave.nextLine();
                garderMonde(nomSauvegarde);
                break;
            case "i":
                if (!jr.getInventaire().isEmpty()) {
                    for (int i = 0; i < jr.getInventaire().size(); i++) {
                        System.out.println("Selectione " + i + " pour utiliser le " + jr.getInventaire().get(i).getClass().getSimpleName());

                    }
                    Scanner scan = new Scanner(System.in);
                    int inventairenumber = scan.nextInt();
                    Utilisable u = jr.getInventaire().get(inventairenumber);


                    //uses first objet
                    if (jr.perso.getPtVie() != 100 && u instanceof PotionSoin) {
                        jr.perso.utiliserObjet((Objet) u);
                        jr.getInventaire().remove(inventairenumber);
                        jr.getEffets().add(u);
                    } else if (u instanceof PotionSoin) {
                        System.out.println("Tu peux pas l'utiliser");
                    }
                    if (u instanceof Epee) {
                        jr.perso.utiliserObjet((Objet) u);
                        jr.getInventaire().remove(inventairenumber);
                        jr.getEffets().add(u);
                    }

                } else {
                    System.out.println("Inventaire Vide");
                }
                break;
            case "y":
                startGame();
                break;
            default:
                System.out.println("Appuyer sur un valeur valide");
                break;
        }
        NuageToxique nuageToxique = ((NuageToxique)eleJeu.get(eleJeu.size()-1));
        nuageToxique.deplace(espaceMatrix);
        int numberRdnx = random1.nextInt(1 + 1) - 1;
        int numberRdny = random1.nextInt(1 + 1) - 1;
        Point2D AtackPoint = new Point2D(nuageToxique.getPos().getX()+numberRdnx,nuageToxique.getPos().getX()+numberRdny);
        if(espaceMatrix.getPositionMatrix(AtackPoint)!=null && espaceMatrix.getPositionMatrix(AtackPoint) instanceof Creature ) {
           nuageToxique.combattre((Creature)espaceMatrix.getPositionMatrix(AtackPoint), espaceMatrix);
        }
        espaceMatrix.affiche(player1,previousElemJeu);
        tourDeJeu(jr,previousElemJeu,null);
    }

    /**
     * Fonction pour sauvegarder un partie
     * @param nomSauvegarde nom pour la pasrtie à sauvegarder
     */
    public void garderMonde(String nomSauvegarde){
        BufferedWriter bw = null;
        try {
            String rute = new File("").getAbsolutePath();
            File file = null;
            if(nomSauvegarde.isEmpty()) {
                FileReader fw = null;
                int version=1;
                while (version >= 1) {
                    try {
                        fw = new FileReader(rute + "/src/saves/sauvegarde" + version + ".txt");
                    } catch (FileNotFoundException e) {
                        file = new File(rute + "/src/saves/sauvegarde"+version+".txt");
                        break;
                    }
                    version+=1;
                }
            } else{
                file = new File(rute + "/src/saves/" + nomSauvegarde + ".txt");
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            String size = "";
            String total = "";

            size = "Size "+this.taille+"\n";

            for (ElementDeJeu e: eleJeu) {
                total+=writePersonnage(e,espaceMatrix);
            }
            for (ElementDeJeu e: eleJeu) {
                total+=writeMonstre(e,espaceMatrix);
            }
            for (ElementDeJeu e: eleJeu) {
                total+=writeObjet(e,espaceMatrix);
            }

            //Ajout personnage jouer
            total+="Joueur "+ writePersonnage(player1.getPerso(), espaceMatrix);

            //Ajout INVENTAIRE
            total+="Inventaire  \n";
            for (Utilisable e: player1.getInventaire()) {
                total+=writeObjet((Objet)e,espaceMatrix);
            }
            total+="Effets \n";
            System.out.println(player1.toString());
            for (Utilisable e: player1.getEffets()) {
                total+=writeObjet((Objet)e,espaceMatrix);
            }

            String joueur = "";

            bw.write(size+total);
            System.out.println("File written Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    /**
     * Fonction pour lire un fichier du type txt
     */
    public void lireMonde(){
        System.out.println("Nom de sauvegarde svp");
        Scanner sclire = new Scanner(System.in);
        String nomSauve = sclire.next();
        BufferedReader bw = null;
        try {
            String rute = new File("").getAbsolutePath();
            FileReader fw = new FileReader(rute+"/src/saves/"+nomSauve+".txt");
            bw = new BufferedReader(fw);

            String mot = "";
            while ((mot = bw.readLine()) != null) {

               String[] phrases = mot.split(" ");
               switch (phrases[0]){
                   case "Size":
                        taille = Integer.parseInt(phrases[1]);
                        break;

                   case "Archer":
                   case "Paysan":
                   case "Guerier":
                        eleJeu.add(readPersonnage(phrases));
                        break;

                   case "Lapin":
                   case "Loup":
                       eleJeu.add(readMonster(phrases));
                       break;

                   case "PotionSoin":
                   case "Epee":
                   case "NuageToxique":
                       eleJeu.add(readObjet(phrases));
                       break;

                   case "Joueur":
                       player1.setInventaire(new ArrayList<>());
                       player1.perso = (Personnage) readPersonnage(Arrays.copyOfRange(phrases, 1, phrases.length));
                       player1.setEffets(new ArrayList<>());
                       mot = bw.readLine();
                       String[] phrases2 = mot.split(" ");
                       if (phrases2[0].equals("Inventaire")){
                           while ((mot = bw.readLine()) != null) {
                               phrases2 = mot.split(" ");
                               if(phrases2[0].equals("PotionSoin") || phrases2[0].equals("Epee") ){
                                   player1.getInventaire().add((Utilisable)readObjet(phrases2));
                               }else{
                                   break;
                               }
                           }
                       }
                       if (phrases2[0].equals("Effets")){
                           while ((mot = bw.readLine()) != null) {
                               phrases2 = mot.split(" ");
                               if(phrases2[0].equals("PotionSoin") || phrases2[0].equals("Epee") ){
                                   player1.getEffets().add((Utilisable)readObjet(phrases2));
                               }
                           }
                       }
                   default:
                       break;
               }
            }


            System.out.println("File read Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
        startGame();
    }


    /**
     * Fonction pour afficher le monde
     */
    public void afficheWorld(){

    }

    /**
     *  Fonction pour construire un fichier text des info des personages
     * @param e element à sauvegarder
     * @param monde monde où l'element se trouve
     * @return Infos des personnages en String
     */
    public String writePersonnage(ElementDeJeu e, Matrix monde){
        String personnage = "";
        if (e instanceof Creature && monde.getPositionMatrix(((Creature)e).getPos())!=null) {
            if (e instanceof Personnage) {
                if (e instanceof Archer) {
                    personnage += "Archer " + ((Archer) e).getNom() + " " + ((Archer) e).getPtVie() + " " + ((Archer) e).getDegAtt() + " " + ((Archer) e).getPtPar() + " " + ((Archer) e).getPageAtt() + " " + ((Archer) e).getPagePar() + " " + ((Archer) e).getDistAttMax() + " " + ((Archer) e).getPos().getX() + " " + ((Archer) e).getPos().getY() + " " + ((Archer) e).getNbFleches()+"\n";
                }
                if (e instanceof Guerrier) {
                    personnage += "Guerrier " + ((Guerrier) e).getNom() + " " + ((Guerrier) e).getPtVie() + " " + ((Guerrier) e).getDegAtt() + " " + ((Guerrier) e).getPagePar() + " " + ((Guerrier) e).getPtPar() + " " + ((Guerrier) e).getPagePar() + " " + ((Guerrier) e).getDistAttMax() + " " + ((Guerrier) e).getPos().getX() + " " + ((Guerrier) e).getPos().getY()+"\n";
                }
                if (e instanceof Paysan) {
                    personnage += "Paysan " + ((Paysan) e).getNom() + " " + ((Paysan) e).getPtVie() + " " + ((Paysan) e).getDegAtt() + " " + ((Paysan) e).getPagePar() + " " + ((Paysan) e).getPtPar() + " " + ((Paysan) e).getPagePar() + " " + ((Paysan) e).getDistAttMax() + " " + ((Paysan) e).getPos().getX() + " " + ((Paysan) e).getPos().getY()+"\n";
                }
            }
        }
        return personnage;
    }


    /**
     *  Fonction pour construire un fichier text des info des Monstres
     * @param e element à sauvegarder
     * @param monde monde où l'element se trouve
     * @return Infos des Monstres en String
     */
    public String writeMonstre(ElementDeJeu e, Matrix monde){
        String monster = "";
        if (e instanceof Creature && monde.getPositionMatrix(((Creature)e).getPos())!=null) {
            if (e instanceof Monstre) {
                if (e instanceof Lapin) {
                    Lapin p = (Lapin) e;
                    monster += "Lapin " + p.getNom() + " " + p.getPtVie() + " " + p.getDegAtt() + " " + p.getPtPar() + " " + p.getPageAtt() + " " + p.getPagePar() + " " + p.getPos().getX() + " " + p.getPos().getY()+"\n";
                }
                if (e instanceof Loup) {
                    Loup p = (Loup) e;
                    monster += "Loup " + p.getNom() + " " + p.getPtVie() + " " + p.getDegAtt() + " " + p.getPtPar() + " " + p.getPageAtt() + " " + p.getPagePar() + " " + p.getPos().getX() + " " + p.getPos().getY()+"\n";
                }
            }
        }
        return monster;
    }

    /**
     *  Fonction pour construire un fichier text des info des Objets
     * @param e element à sauvegarder
     * @param monde monde où l'element se trouve
     * @return Infos des Objets en String
     */
    public String writeObjet(ElementDeJeu e, Matrix monde){
        String objets="";
        if (e instanceof Objet && monde.getPositionMatrix(((Objet)e).getPos())!=null) {
            if (e instanceof PotionSoin) {
                PotionSoin p = (PotionSoin) e;
                objets += "PotionSoin " + p.getUses() + " " + p.getPtRevit() + " " + p.getPos().getX() + " " + p.getPos().getY()+"\n";
            }
            if (e instanceof Epee) {
                Epee p = (Epee) e;
                objets += "Epee " + p.getPtdegat() + " " + p.getPos().getX() + " " + p.getPos().getY()+"\n";
            }
            if (e instanceof NuageToxique) {
                NuageToxique p = (NuageToxique) e;
                objets += "NuageToxique " + p.getDegAtt() + " " + p.getPos().getX() + " " + p.getPos().getY()+"\n";
            }
        }
        return objets;
    }

    /**
     * Fonction pour lire un fichier txt et constuire un personage
     * @param s ligne à lire
     * @return Creature crée
     */
    public Creature readPersonnage(String[] s){
        Creature c = new Creature();
        if (s[0].equals("Archer")) {
            c = new Archer(s[1],
                    Integer.parseInt(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5]),
                    Integer.parseInt(s[6]),
                    Integer.parseInt(s[7]),
                    new Point2D(Integer.parseInt(s[8]),Integer.parseInt(s[9])),
                    Integer.parseInt(s[9]));
        }
        if (s[0].equals("Guerrier")) {
            c = new Guerrier(s[1],
                    Integer.parseInt(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5]),
                    Integer.parseInt(s[6]),
                    Integer.parseInt(s[7]),
                    new Point2D(Integer.parseInt(s[8]),Integer.parseInt(s[9])));        }
        if (s[0].equals("Paysan")) {
            c = new Paysan(s[1],
                    Integer.parseInt(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5]),
                    Integer.parseInt(s[6]),
                    Integer.parseInt(s[7]),
                    new Point2D(Integer.parseInt(s[8]), Integer.parseInt(s[9])));
        }
        return c;
    }
    /**
     * Fonction pour lire un fichier txt et constuire un Objet
     * @param s ligne à lire
     * @return Objet crée
     */
    public Objet readObjet(String[] s){
        Objet c = new Objet();
        if (s[0].equals("PotionSoin")) {
            c = new PotionSoin(new Point2D(Integer.parseInt(s[3]), Integer.parseInt(s[4])),
                    Integer.parseInt(s[1]),  Integer.parseInt(s[2]));
        }
        if (s[0].equals("Epee")) {
            c = new Epee(
                    new Point2D(Integer.parseInt(s[2]), Integer.parseInt(s[3])),
                    Integer.parseInt(s[1]));
        }
        if (s[0].equals("NuageToxique")) {
            c = new NuageToxique(
                    new Point2D(Integer.parseInt(s[2]), Integer.parseInt(s[3])),
                    Integer.parseInt(s[1]));
        }
        return c;
    }
    /**
     * Fonction pour lire un fichier txt et constuire un Monstre
     * @param s ligne à lire
     * @return Monstre crée
     */
    public Creature readMonster(String[] s){
        Creature c = new Creature();
        if (s[0].equals("Lapin")) {
            c = new Lapin(s[1],
                    Integer.parseInt(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5]),
                    Integer.parseInt(s[6]),
                    new Point2D(Integer.parseInt(s[7]),Integer.parseInt(s[8])));
        }
        if (s[0].equals("Loup")) {
            c = new Loup(s[1],
                    Integer.parseInt(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5]),
                    Integer.parseInt(s[6]),
                    new Point2D(Integer.parseInt(s[7]),Integer.parseInt(s[8])));
        }
        return c;
    }
}
