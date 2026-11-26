package fr.ubordeaux.ao.keyboardadventure.model;

import fr.ubordeaux.ao.keyboardadventure.model.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Battle {

    // Properties :
    private static final long PERIOD = 10; // Attack delay in s
    private Player player;
    private List<Enemy> enemies;
    private List<Enemy> projectlist = new ArrayList<Enemy>();

    private long clock;
    private long prevDateTime;

    // Constructor :
    public Battle(Player player, List<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;
        this.clock = 0;
        this.prevDateTime = System.currentTimeMillis();
                for (Enemy enemy : enemies){
            enemy.setBattle(this);
        }
    }

    // Methods :
    public void run(Player player) {
        this.player = player;
        start();
        while(!isOver()) {
            processClock();
        }
    }

    public void start() {
        // Restore enemies health
        for(Enemy enemy : enemies) {
            enemy.reset();
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
            if(enemy.isAlive()){
                enemy.attack(player);
            }
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

    public void addEnemy(Enemy enemy){
        enemy.setBattle(this);
        enemies.add(enemy);
    }

    public void addProjectile(Enemy enemy){
        projectlist.add(enemy);
        enemy.setBattle(this);
        enemy.attack(player);
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
}
