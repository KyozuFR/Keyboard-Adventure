package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public class ConcreteEnemy implements Enemy {

    // Properties :
    private int HP = 1;
    private float speed = 1;
    private String word = "araigne";

    // Constructors :
    public ConcreteEnemy(){

    }

    public ConcreteEnemy(int HP, float speed, String word){
        this.HP = HP;
        this.speed = speed;
        this.word = word;
    }

    // Methods :
    @Override
    public String getWord() {
        return word;
    }

    @Override
    public void attack(Entity entity) {

    }

    @Override
    public void hurt(int damage) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
