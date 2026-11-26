package fr.ubordeaux.ao.keyboardadventure.model;

import fr.ubordeaux.ao.keyboardadventure.model.enemy.Enemy;

import java.util.List;

public class Battle {

    // Properties :
    private static final long PERIOD = 7; // Attack delay in s
    private Player player;
    private List<Enemy> enemies;
    private long clock;
    private long prevDateTime;

    // Constructor :
    public Battle(Player player, List<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;
        this.clock = 0;
        this.prevDateTime = System.currentTimeMillis();
    }

    // Methods :
    public void run() {
        start();
        while(!isOver()) {
            processClock();
        }
    }

    public void start() {
        // Restore enemies health
        for(Entity entity : enemies) {
            entity.reset();
        }
    }

    public boolean isOver() {

        // Condition de défaite (le joueur est vaincu)
        if(player.getHealth() <= 0) {
            return true;
        }

        // Condition de victoire (tous les ennemy sont vaincus)
        for(Enemy enemy : enemies) {
            if (enemy.getHealth() > 0) {
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
                player.attack(enemy);
            }
        }
    }

    public void processClock() {
        long currentDateTime = System.currentTimeMillis();
        clock += currentDateTime - prevDateTime;
        prevDateTime = currentDateTime;

        if(clock >= PERIOD * 1000) {
            this.enemiesAttack();
            clock = 0;
        }
    }

    public int countEnemy() {
        return enemies.size();
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
