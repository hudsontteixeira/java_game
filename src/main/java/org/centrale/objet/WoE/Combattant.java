package org.centrale.objet.WoE;
/**
 * Interface Combattant
 * @author LOPEZ TEIXEIRA
 * @version 1.0
 */
public interface Combattant {
    /**
     * Fonction de combattre avec une créature
     * @param C  c'est la creature avec on va avoir un combatt
     * @param monde lieu où on a le combatt
     */
    void combattre(Creature C, Matrix monde);
}
