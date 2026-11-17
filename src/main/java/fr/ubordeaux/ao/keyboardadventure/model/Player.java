package fr.ubordeaux.ao.keyboardadventure.model;

public class Player implements Entity {

    // Properties :
    private int maxHealth;
    private int health;
    private String currentWord;
    private int attack;

    // Constructor :
    public Player(int health) {
        this.maxHealth = health;
        this.health = health;
        this.currentWord = "";
    }

    // Methods :
    public void writeChar(char c) {
        currentWord += c;
    }

    public void eraseChar() {
        if(currentWord == null || currentWord.isEmpty()) {
            return;
        }
        currentWord = currentWord.substring(0, currentWord.length()-1);
    }

    public String submitWord() {
        String result = currentWord;
        currentWord = "";
        return result;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void attack(Entity entity) {
        entity.hurt(attack);
    }

    @Override
    public void hurt(int damage) {
        this.health -= damage;
    }

    @Override
    public void reset() {
        health = maxHealth;
    }
}

