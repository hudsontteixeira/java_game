package org.centrale.objet.WoE;
import java.util.*;
/**
 * Classe de création du Monde
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class World {

    Jouer player1 = new Jouer();
    ArrayList<Creature> creatures;
    ArrayList<ElementDeJeu> eleJeu;
    NuageToxique nuageToxique;
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
    int taille;
    Matrix espaceMatrix;

    /**
     * Fonction que demande une option de jeu pour commencer
     */
    public void startGame(){
        System.out.println("Bienvenue dans WoE : Pour tester un monde aléatoire appuyez 1,") ;
        System.out.println("pour générer un monde de combat appuyez 2, pour tester un monde avec de grandes collections et tester leurs performances appuyez 3,");
        System.out.println("pour générer un monde où les personnages ne peuvent pas se chevaucher appuyez 4.");
        System.out.println("pour atribuire un personnage jouable à un jouer appuyez 6.");
        Scanner sc = new Scanner(System.in);
        int startOption = sc.nextInt();
        if(startOption==1){
            this.creerMondeAlea();
        }
        if(startOption==2){
            this.creerCombatMondeAlea();
        }
        if(startOption==3){
            this.creerMondeAleaCollections();
        }
        if(startOption==4){
            this.creerMatrixPosition();
        }
        if(startOption==5){
            this.creerCombatMondeAleaException();
        } if(startOption==6){
            this.creerCombatJuable();
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
        System.out.println("Guerrier essaie prendre potion loin");
        grosBill.prendObjet(possionMagic,espaceMatrix);
        System.out.println("Guerrier essaie prendre potion bonne place");
        grosBill.setPos(new Point2D(11,11));
        grosBill.prendObjet(possionMagic,espaceMatrix);
        System.out.println("Guerrier ptVie:"+grosBill.getPtVie());
        System.out.println("Guerrier essaie prendre Epee loin");
        grosBill.prendObjet(sword,espaceMatrix);
        System.out.println("Guerrier essaie prendre Epee bonne place");
        System.out.println("Guerrier degat avant:"+grosBill.getDegAtt());
        grosBill.setPos(new Point2D(10,10));
        grosBill.prendObjet(sword,espaceMatrix);
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
    public void AddAleaCollections(){
        taille = 9;
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
        int nbArcher =  0;
        int nbPaysan =  0;
        int nbLapin =  0;
        int nbGuerrier =  0;
        int nbLoup =  0;

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
        eleJeu.add(new PotionSoin(new Point2D(),10));
        eleJeu.add(new PotionSoin(new Point2D(),10));

        //CREATION DE POINTS
        ArrayList<Point2D> points = new ArrayList<>();
        boolean  different = true;
        //points EleJeu
        while(points.size()<eleJeu.size()){
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
        while(pointsNuage.size()<numberOfNuages){
            Point2D point = new Point2D(random.nextInt(taille), random.nextInt(taille));
            different = true;
            for(Point2D p: points){
                if(p.x == point.x && p.y == point.y){
                    different = false;
                    break;
                }
            }
            if(different) {
                pointsNuage.add(point);
            }
        }
        nuageToxique = new NuageToxique(pointsNuage.get(0));

        for (int i=0; i<eleJeu.size(); i++){
            if(eleJeu.get(i) instanceof Creature) {
                ((Creature)eleJeu.get(i)).setPos(points.get(i));
            }
            if(eleJeu.get(i) instanceof Objet) {
                ((Objet)eleJeu.get(i)).setPos(points.get(i));
            }
           espaceMatrix.setPositionMatrix(points.get(i),eleJeu.get(i));
        }

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
    }

    public void creerCombatJuable(){
        taille = 9;
        espaceMatrix = new Matrix(new ElementDeJeu[taille][taille]);
        Creature previousElemJeu = null;
        AddAleaCollections();
        player1.choosePersonnage();
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
    public void tourDeJeu(Jouer jr, Creature previousElemJeu, String recursive){
        String option;
        Random random1 = new Random();
        if(recursive == null) {
                System.out.println("awsd pour boger ou q pour attaquer, i inventory and p prendre objet");
                Scanner sc = new Scanner(System.in);
                option = sc.nextLine();
            }
        else {
                option = recursive;
            }


            if (option.equals("a") || option.equals("w") || option.equals("s") || option.equals("d")) {
                jr.deplace(espaceMatrix,option);
                espaceMatrix.affiche(player1,null);
                previousElemJeu = null;
            }
            else if (option.equals("q")) {
                int numberRdnx = random1.nextInt(1 + 1) - 1;
                int numberRdny = random1.nextInt(1 + 1) - 1;
                if(jr.persoClass.equals("Archer")){
                     numberRdnx = random1.nextInt(((jr.perso).getDistAttMax()-1) + ((jr.perso).getDistAttMax()-1) ) - ((jr.perso).getDistAttMax()-1);
                     numberRdny = random1.nextInt(((jr.perso).getDistAttMax()-1) + ((jr.perso).getDistAttMax()-1) ) - ((jr.perso).getDistAttMax()-1);
                }
                Point2D AtackPoint = new Point2D(jr.perso.getPos().getX()+numberRdnx,jr.perso.getPos().getX()+numberRdny);

                    //start new fight
                    if (previousElemJeu == null) {
                        if(espaceMatrix.getPositionMatrix(AtackPoint)!=null && espaceMatrix.getPositionMatrix(AtackPoint) instanceof Creature ) {
                            if (jr.persoClass == "Guerrier") {
                                Guerrier Warrior = (Guerrier) jr.perso;
                                Warrior.combattre((Creature) espaceMatrix.getPositionMatrix(AtackPoint), espaceMatrix);
                                previousElemJeu = (Creature) espaceMatrix.getPositionMatrix(AtackPoint);
                                if(previousElemJeu instanceof Loup){
                                    ((Loup) previousElemJeu).combattre(jr.perso,espaceMatrix);
                                }
                                if(previousElemJeu instanceof Archer){
                                    ((Archer) previousElemJeu).combattre(jr.perso,espaceMatrix);
                                }
                                if(previousElemJeu instanceof Guerrier){
                                    ((Guerrier) previousElemJeu).combattre(jr.perso,espaceMatrix);
                                }
                            }
                            if (jr.persoClass == "Archer") {
                                Archer Archer = (Archer) jr.perso;
                                Archer.combattre((Creature) espaceMatrix.getPositionMatrix(AtackPoint), espaceMatrix);
                                previousElemJeu = (Creature) espaceMatrix.getPositionMatrix(AtackPoint);
                                if(previousElemJeu instanceof Loup){
                                    ((Loup) previousElemJeu).combattre(jr.perso,espaceMatrix);
                                }
                                if(previousElemJeu instanceof Archer){
                                    ((Archer) previousElemJeu).combattre(jr.perso,espaceMatrix);
                                }
                                if(previousElemJeu instanceof Guerrier){
                                    ((Guerrier) previousElemJeu).combattre(jr.perso,espaceMatrix);
                                }
                            }
                        } else {
                            tourDeJeu(jr,previousElemJeu,"q");
                        }
                    }
                    else{
                        //Existent fight
                        if(previousElemJeu instanceof Creature) {
                            if (jr.persoClass == "Guerrier") {
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
                            if (jr.persoClass == "Archer") {
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

            }
            else if (option.equals("p")){
                //prend Objet
                int numberRdnx = random1.nextInt(1 + 1) - 1;
                int numberRdny = random1.nextInt(1 + 1) - 1;
                Point2D ObjetPoint = new Point2D(jr.perso.getPos().getX()+numberRdnx,jr.perso.getPos().getX()+numberRdny);
                if(espaceMatrix.getPositionMatrix(ObjetPoint)!=null){
                    jr.perso.prendObjet((Objet)espaceMatrix.getPositionMatrix(ObjetPoint),espaceMatrix);
                } else {
                    tourDeJeu(jr,null,"p");
                }
            }
            else if(option.equals("i")){
               if(!jr.perso.getInventaire().isEmpty()){
                    for (int i = 0; i<jr.perso.getInventaire().size(); i++){
                     System.out.println("Selectione "+ i + "pour utiliser le" + jr.perso.getInventaire().get(i).getClass().getSimpleName());
                    }
                    Scanner scan = new Scanner(System.in);
                    int inventairenumber = scan.nextInt();
                  //uses first objet
                  jr.perso.utiliserObjet((Objet)jr.perso.getInventaire().get(inventairenumber));

               }  else{
                   System.out.println("Inventory Vide");
               }
            }else{
                System.out.println("Appueyr sur un valeur valide");
            }
            //nuage allways try to kill and moove randonly
            //nuageToxique.deplace(espaceMatrix);
            //int numberRdnx = random1.nextInt(1 + 1) - 1;
            //int numberRdny = random1.nextInt(1 + 1) - 1;
            //Point2D AtackPoint = new Point2D(nuageToxique.getPos().getX()+numberRdnx,nuageToxique.getPos().getX()+numberRdny);
            //if(espaceMatrix.getPositionMatrix(AtackPoint)!=null && espaceMatrix.getPositionMatrix(AtackPoint) instanceof Creature ) {
             //   nuageToxique.combattre((Creature)espaceMatrix.getPositionMatrix(AtackPoint), espaceMatrix);
            //}
            //refresh
            System.out.println();
            espaceMatrix.affiche(player1,previousElemJeu);
            tourDeJeu(jr,previousElemJeu,null);
    }

    /**
     * Fonction pour afficher le monde
     */
    public void afficheWorld(){

    }

}
