package org.centrale.objet.WoE;

public class Nourriture extends Objet implements Utilisable {
    private int tours;
    private int valueAugmenter;
    private int uses;

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

    @Override
    public void decrementer() {
        this.uses-=1;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
