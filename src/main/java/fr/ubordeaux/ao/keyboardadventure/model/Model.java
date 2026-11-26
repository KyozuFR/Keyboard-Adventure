package fr.ubordeaux.ao.keyboardadventure.model;

import fr.ubordeaux.ao.keyboardadventure.model.enemy.ConcreteEnemy;
import fr.ubordeaux.ao.keyboardadventure.model.enemy.Enemy;
import fr.ubordeaux.ao.keyboardadventure.model.enemy.EnemyBuilder;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject {

    // Properties:
    private Donjon donjon;
    private Player player;
    private static List<Observer> observers;
    private ModelState state;

    // Constructors :
    public Model() {
        Model.observers = new ArrayList<>();
        state =  new ModelDonjon(this, player, donjon);
    }

    // Methods :
    public void debugDonjon() {
        player = new Player(50);
        List<Enemy> enemies = new ArrayList<>();

        EnemyBuilder builder = EnemyBuilder.baseEnemy();
        enemies.add(builder.build());
        builder = EnemyBuilder.baseEnemy();
        enemies.add(builder.build());

        List<Battle> battles = new ArrayList<>();
        battles.add(new Battle(player, enemies));
        Donjon donjon = new Donjon(battles);

        startDonjon(player, donjon);
    }

    public void startDonjon(Player player, Donjon donjon) {
        this.donjon = donjon;
        donjon.run(player);
    }

    public void submitWord() {
        state.submitWord();
        notifyObservers();
    }

    public void typeChar(char c) {
        state.typeChar(c);
        notifyObservers();
    }

    public void eraseChar() {
        state.eraseChar();
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public static void notifyStartBattleObservers(int n, List<String> labels) {
        for(Observer o : observers) {
            if (o instanceof BattleObserver b) {
                o.updateStartBattle(n, labels);
            }
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }
}
