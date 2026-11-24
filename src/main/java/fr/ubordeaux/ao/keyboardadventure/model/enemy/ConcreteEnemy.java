package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public class ConcreteEnemy extends Entity implements Enemy {

    // Properties :
    private String word = "araigne";
    // Constructors :
    public ConcreteEnemy(){
        super(1, 1);
    }
    public ConcreteEnemy(int HP, String word,int damage){
        super(HP, damage);
        this.word = word;
    }

    // Methods :
    @Override
    public String getWord() {
        return word;
    }
}
