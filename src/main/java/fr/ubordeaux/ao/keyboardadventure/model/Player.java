package fr.ubordeaux.ao.keyboardadventure.model;

public class Player extends Entity {

    // Properties :
    private String currentWord;

    // Constructor :
    public Player(int health,int Damage) {
        super(health,Damage);
        this.currentWord = "";
    }
    
    @Override
    public void hurt(int damage){
        super.hurt(damage);
        System.out.println("Player took " + damage + " damage");
        System.out.println("current life: " + this.health);
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

    public String getCurrentWord(){
        return currentWord;
    }
}

