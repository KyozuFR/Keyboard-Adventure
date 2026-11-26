package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import fr.ubordeaux.ao.keyboardadventure.model.Entity;
import fr.ubordeaux.ao.keyboardadventure.model.Player;

public class EnemyBuilder {

    // Properties :
    private Enemy enemy;

    // Constructors :
    private EnemyBuilder(ConcreteEnemy enemy) {
        this.enemy = enemy;
    }

    // Constructors
    public static EnemyBuilder baseEnemy() {
        return new EnemyBuilder(new ConcreteEnemy());
    }

    public EnemyBuilder dummyEnemy() {
        this.enemy = new DummyEnemyDecorator(enemy);
        return this;
    }

    public EnemyBuilder fireEnemy(){
        //voir pour battle
        this.enemy = new FireEnemyDecorator(enemy);
        return this;
    }

    public EnemyBuilder fireBall(Entity player){
        this.enemy = new FireBallEnemyDecorator(enemy);
        return this;
    }

    public Enemy build(){
        return enemy;
    }
}
