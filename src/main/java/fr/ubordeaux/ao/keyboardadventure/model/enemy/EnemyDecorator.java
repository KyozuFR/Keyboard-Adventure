package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Battle;
import fr.ubordeaux.ao.keyboardadventure.model.Entity;

abstract class EnemyDecorator implements Enemy {

    // Properties :
    private final Enemy enemyDecorator;

    // Constructors :
    protected EnemyDecorator(Enemy enemyDecorator){
        this.enemyDecorator = enemyDecorator;
    }

    // Methods :
    @Override
    public String getWord() {
        return enemyDecorator.getWord();
    }

    @Override
    public void attack(Entity entity) {
        enemyDecorator.attack(entity);
    }

    @Override
    public void hurt(int damage) {
        enemyDecorator.hurt(damage);
    }

    @Override
    public void reset() {
        enemyDecorator.reset();
    }

    @Override 
    public  void die(){
        enemyDecorator.die();
    }
    @Override 
    public boolean isAlive(){
        return enemyDecorator.isAlive();
    }

    @Override
    public void setBattle(Battle battle){
        enemyDecorator.setBattle(battle);
    }

    @Override
    public Battle getBattle(){
        return enemyDecorator.getBattle();
    }
}
