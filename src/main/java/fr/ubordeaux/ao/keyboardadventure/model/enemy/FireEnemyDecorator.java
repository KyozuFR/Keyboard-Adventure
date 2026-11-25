package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Battle;
import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public class FireEnemyDecorator extends EnemyDecorator{
    Battle battle;
    EnemyBuilder FireBallBuilder;
    public FireEnemyDecorator(Enemy enemy,Battle battle){
        super(enemy);
        this.battle = battle;
        FireBallBuilder = EnemyBuilder.baseEnemy().fireBall();
    }

    @Override
    public String getWord() {
        return super.getWord();
    }

    @Override 
    public void attack(Entity entity){
      battle.addEnemy(FireBallBuilder.build());   
    }
}
