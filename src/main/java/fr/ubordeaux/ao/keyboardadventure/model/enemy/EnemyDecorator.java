package fr.ubordeaux.ao.keyboardadventure.model.enemy;

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

    }

    @Override
    public void hurt(int damage) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
