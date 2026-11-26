package fr.ubordeaux.ao.keyboardadventure.model;

import java.util.List;

public class Donjon {

    // Properties :
    Player player;
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
}
