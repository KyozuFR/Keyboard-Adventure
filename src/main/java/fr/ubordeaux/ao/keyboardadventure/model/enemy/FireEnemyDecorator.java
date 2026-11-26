package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Battle;
import fr.ubordeaux.ao.keyboardadventure.model.Entity;

public class FireEnemyDecorator extends EnemyDecorator{
    EnemyBuilder Builder;
    public FireEnemyDecorator(Enemy enemy){
        super(enemy);
        Builder = EnemyBuilder.baseEnemy();
    }

    @Override
    public String getWord() {
        return super.getWord();
    }

    @Override 
    public void attack(Entity entity){
      this.getBattle().addProjectile(Builder.fireBall(entity).build());
      System.out.println("fireBall Created");
    }
}
