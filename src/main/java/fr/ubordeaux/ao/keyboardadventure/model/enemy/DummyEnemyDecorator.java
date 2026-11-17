package fr.ubordeaux.ao.keyboardadventure.model.enemy;

public class DummyEnemyDecorator extends EnemyDecorator {

    // Constructors :
    DummyEnemyDecorator(Enemy enemy){
        super(enemy);
    }

    // Methods :
    @Override
    public String getWord() {
        return super.getWord() + " dumbass";
    }
}
