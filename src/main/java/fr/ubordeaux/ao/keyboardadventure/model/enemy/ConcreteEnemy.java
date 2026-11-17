package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public class ConcreteEnemy implements Enemy {

    // Properties :
    private int maxHP = 1;
    private int HP = maxHP;
    private String word = "araigne";
    private  int damage = 1;

    // Constructors :
    public ConcreteEnemy(){

    }

    public ConcreteEnemy(int HP, String word,int damage){
        this.maxHP = HP;
        this.HP = maxHP;
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
        HP -= damage;
        if(HP<=0){
            die();
        }
    }

    @Override
    public int getHealth() {
        return this.HP;
    }

    @Override
    public void reset() {
        HP = maxHP;
    }

    private void die(){
        //TO DO
    }
}
