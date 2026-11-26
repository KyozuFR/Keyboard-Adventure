package fr.ubordeaux.ao.keyboardadventure.model;

import fr.ubordeaux.ao.keyboardadventure.model.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Donjon {

    // Properties :
    private Player player;
    private final List<Battle> battles;
    private int index;

    // Constructor
    public Donjon(List<Battle> battles) {
        this.battles = battles;
        this.index = 0;
    }

    // Methods :
    public void start(Player player) {
        this.player = player;
        this.index = 0;
    }

    public void run(Player player) {
        start(player);
        while (!isOver()) {
            Battle battle = getCurrentBattle();

            List<String> labels = new ArrayList<>();
            for(Enemy enemy : battle.getEnemies()) {
                labels.add(enemy.getWord());
            }

            Model.notifyStartBattleObservers(battle.countEnemy(), labels);
            battle.run(player);
            nextBattle();
        }
    }

    public boolean isOver() {
        return battles.size() == index;
    }

    public void nextBattle() {
        index++;
    }

    public Battle getCurrentBattle() {
        return battles.get(index);
    }

    public Player getPlayer() {
        return player;
    }
}
