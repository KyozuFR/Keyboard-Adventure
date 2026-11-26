package fr.ubordeaux.ao.keyboardadventure.model;

import fr.ubordeaux.ao.keyboardadventure.model.Debuff.Debuff;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    private int maxHealth;
    public int health;
    private int attack;
    private  boolean isAlive = true;

    public  Entity(int health, int attack ){
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
    }

    public void addDebuff(Debuff debuff){
        debuff.applyEffect(this);
    }
    public void attack(Entity entity) {
        entity.hurt(attack);
    }

    public void hurt(int damage) {
        this.health -= damage;
    }


    public void reset() {
        health = maxHealth;
        isAlive = true;
    }

    public  boolean isAlive(){
        return isAlive;
    }

    public  void  die(){
        isAlive = false;
    }
}
