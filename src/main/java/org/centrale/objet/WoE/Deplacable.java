package org.centrale.objet.WoE;
import java.util.Random;
public interface Deplacable {
    /**
     * Methòde pour changer la position de une creature dans le monde sans chevauchement.
     *
     * @param monde monde avec les tailles e contraints definit
     */
    void deplace(Matrix monde);
}