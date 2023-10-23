package org.centrale.objet.WoE;

/**
 * Classe Nourriture
 */
public class Nourriture extends Objet implements Utilisable {
    private int tours;
    private int valueAugmenter;
    private int uses;

    /**
     * Constructeur pour créer un Objet de la classe nourriture
     * @param tours nombre de tours de jeu qui l'effet de la nourriture sera active
     * @param valueAugmenter valeurs à ajouter aux points de vie du personnage
     */
    public Nourriture(int tours, int valueAugmenter) {
        this.tours = tours;
        this.valueAugmenter = valueAugmenter;
    }

    /**
     * Metode pour savoir combien de tour se sont passé avec l'objet
     * @return le nombre de tours passé
     */
    public int getTours() {
        return tours;
    }

    /**
     * Getter pour prende la valeur à augmenter dans les points de vie
     * @return les points à augmenter
     */
    public int getValue() {
        return valueAugmenter;
    }

    /**
     * Méthode pour decrementer le nombre de utilisation d'iobjet
     */
    @Override
    public void decrementer() {
        this.uses-=1;
    }

    /**
     * Méthode pour prendre la quantité de utilisation disponible du objet
     * @return
     */
    public int getUses() {
        return uses;
    }

    /**
     * Méthode pour changer la quantité de utilisation du objet
     * @param uses
     */
    public void setUses(int uses) {
        this.uses = uses;
    }
}
