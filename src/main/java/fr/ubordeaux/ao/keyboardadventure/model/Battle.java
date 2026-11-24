package fr.ubordeaux.ao.keyboardadventure.model;

import fr.ubordeaux.ao.keyboardadventure.model.enemy.Enemy;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Battle {

    // Properties :
    private static final long DELAY = 10; // Attack delay in s
    private Player player;
    private Timer timer;
    private List<Enemy> enemies;


    // Constructor :
    public Battle(Player player, List<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;

        this.timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                enemiesAttack();
            }
        };
        timer.schedule(task, DELAY * 1000);
    }

    // Methods :
    public void run() {
        start();
        while(!isOver()) {
            System.out.println("Run");
        }
    }

    public void start() {
        // Restore enemies health
        for(Enemy entity : enemies) {
            entity.reset();
        }
    }

    public boolean isOver() {

        // Condition de défaite (le joueur est vaincu)
        if(!player.isAlive()) {
            return true;
        }

        // Condition de victoire (tous les ennemy sont vaincus)
        for(Enemy enemy : enemies) {
            if(enemy.isAlive()){
                return false;
            }
        }
        return true;
    }

    public void enemiesAttack() {
        for (Enemy enemy : enemies) {
            enemy.attack(player);
        }
    }

    public void playerSubmit() {
        String word = player.submitWord();
        for(Enemy enemy : enemies) {
            if(word.compareTo(enemy.getWord()) == 0) {
                player.attack((Entity) enemy);
            }
        }
    }
}
