package org.centrale.objet.WoE;

public class Nourriture extends Objet implements Utilisable {
    private int tours;
    private int valueAugmenter;

    public Nourriture(int tours, int valueAugmenter) {
        this.tours = tours;
        this.valueAugmenter = valueAugmenter;
    }

    public int getTours() {
        return tours;
    }

    public int getValue() {
        return valueAugmenter;
    }
}
