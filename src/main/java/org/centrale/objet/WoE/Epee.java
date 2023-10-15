package org.centrale.objet.WoE;
/**
 * Classe de création de Epee
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public class Epee extends Objet implements Utilisable{
    private int ptdegat;
    private int uses;

    /**
     * Constructeur pour un Epee
     * @param pos position donnée d'objet
     * @param ptdegat points de degat à augmenter dans un personnage
     */
    public Epee(Point2D pos, int ptdegat) {
        super(pos);
        this.ptdegat = ptdegat;
    }

    /**
     * Constructeur de copie d'un Epee
     * @param epee Epee à être clone
     */
    public Epee(Epee epee) {
        super(epee);
    }

    /**
     * Getter pour prendre valeur de degat à augmenter
     * @return  valeu de degat à augmenter
     */
    public int getPtdegat() {
        return ptdegat;
    }

    /**
     * Setter pour changer valeur de degat à augmenter dans un personnage
     * @param ptdegat nouveau points de degat à augmenter dans un personnage
     */
    public void setPtdegat(int ptdegat) {
        this.ptdegat = ptdegat;
    }

    @Override
    public void decrementer() {
        uses-=1 ;
    }
}
