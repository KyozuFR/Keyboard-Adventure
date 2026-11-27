package fr.ubordeaux.ao.keyboardadventure.model;

import fr.ubordeaux.ao.keyboardadventure.model.debuff.Debuff;

public abstract class Entity {

    // Properties :
    private int maxHealth;
    public int health;
    private int attack;
    private  boolean isAlive = true;

    // Constructor :
    public  Entity(int health, int attack ){
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
    }

    // Methods :
    public void addDebuff(Debuff debuff){
        debuff.applyEffect(this);
    }

    public void attack(Entity entity) {
        entity.hurt(attack);
    }

    public void hurt(int damage) {
        health -= damage;
        if(health <= 0) {
            die();
        }
    }


    public void reset() {
        health = maxHealth;
        isAlive = true;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void die(){
        isAlive = false;
    }
}
