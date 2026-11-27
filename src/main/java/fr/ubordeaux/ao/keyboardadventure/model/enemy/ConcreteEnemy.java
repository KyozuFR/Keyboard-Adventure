package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Battle;
import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public class ConcreteEnemy extends Entity implements Enemy {

    // Properties :
    private String word = "araigne";
    private Battle battle;


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

    @Override
    public void setBattle(Battle battle){
        this.battle = battle;
    }

    @Override
    public Battle getBattle(){
        return this.battle;
    }
}
