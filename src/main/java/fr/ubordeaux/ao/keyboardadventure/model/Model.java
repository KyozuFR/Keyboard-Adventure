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

    // Constructors :
    public Model() {
        Model.observers = new ArrayList<>();
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
        donjon.getCurrentBattle().playerSubmit();
        System.out.println("Fait");
        notifyObservers();
    }

    public void typeChar(char c) {
        player.writeChar(c);
        notifyObservers();
    }

    public void eraseChar() {
        player.eraseChar();
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

    public static void notifyStartBattleObservers(int n) {
        for(Observer o : observers) {
            o.updateStartBattle(n);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }
}
