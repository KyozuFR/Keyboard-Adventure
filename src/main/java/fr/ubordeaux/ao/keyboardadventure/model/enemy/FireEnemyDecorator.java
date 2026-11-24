package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Battle;
import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public class FireEnemyDecorator extends EnemyDecorator{

    public FireEnemyDecorator(Enemy enemy){
        super(enemy);
    }

    @Override
    public String getWord() {
        return super.getWord();
    }

    @Override 
    public void attack(Entity entity){
     Battle.addEnnemy(new FireBall);   
    }
}
