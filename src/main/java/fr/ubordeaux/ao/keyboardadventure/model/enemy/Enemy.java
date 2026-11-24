package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public interface Enemy{
    String getWord();


    void attack(Entity entity);

    void hurt(int damage);

    boolean isAlive();
    /*
     * Reset Entity health to his max
     */
    void reset();

    void die();
}
