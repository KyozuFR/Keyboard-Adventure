package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public class ConcreteEnemy implements Enemy {

    // Properties :
    private int maxHealth = 1;
    private int health = maxHealth;
    private String word = "araigne";
    private  int damage = 1;

    // Constructors :
    public ConcreteEnemy(){

    }

    public ConcreteEnemy(int health, String word, int damage){
        this.maxHealth = health;
        this.health = maxHealth;
        this.word = word;
        this.damage = damage;
    }

    // Methods :
    @Override
    public String getWord() {
        return word;
    }

    @Override
    public void attack(Entity entity) {
        entity.hurt(damage);
    }

    @Override
    public void hurt(int damage) {
        health -= damage;
        if(health <=0){
            die();
        }
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void reset() {
        health = maxHealth;
    }

    private void die(){
        //TO DO
    }
}
