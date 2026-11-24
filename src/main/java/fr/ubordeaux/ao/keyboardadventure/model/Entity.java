package fr.ubordeaux.ao.keyboardadventure.model;

public interface Entity {

    void attack(Entity entity);

    void hurt(int damage);

    int getHealth();

    /*
     * Reset Entity health to his max
     */
    void reset();
}
