package fr.ubordeaux.ao.keyboardadventure.model.enemy;

public class EnemyBuilder {

    // Properties :
    private Enemy enemy;

    // Constructors :
    private EnemyBuilder(ConcreteEnemy enemy){
        this.enemy = enemy;
    }

    // Constructors
    public static EnemyBuilder baseEnemy(){
        return new EnemyBuilder(new ConcreteEnemy());
    }

    public EnemyBuilder dummyEnemy(){
        this.enemy = new DummyEnemyDecorator(enemy);
        return this;
    }

    public Enemy build(){
        return enemy;
    }
}
