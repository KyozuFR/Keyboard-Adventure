package fr.ubordeaux.ao.keyboardadventure.model;

import fr.ubordeaux.ao.keyboardadventure.model.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    // Properties :
    private static final long PERIOD = 7; // Attack delay in s
    private Player player;
    private List<Enemy> enemies;
    private List<Enemy> projectlist = new ArrayList<Enemy>();
    private long clock;
    private long prevDateTime;

    // Constructor :
    public Battle(List<Enemy> enemies) {
        this.enemies = enemies;
        this.clock = 0;
        this.prevDateTime = System.currentTimeMillis();
    }

    // Methods :
    public void run(Player player) {
        this.player = player;
        start();
        while(!isOver()) {
            processClock();
        }
        System.out.println("Fini !");
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
        int count = 0;
        for(Enemy enemy : enemies) {
            if (!enemy.isAlive()) {
                count++;
            }
        }
        return count == enemies.size();
    }

    public void enemiesAttack() {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if(enemy.isAlive()) {
                enemy.attack(player);
                Model.notifyEnemyAttackObservers(i);
            }
        }
    }

    public void playerSubmit() {
        System.out.println("Begin submit");

        String word = player.submitWord();

        for(int i = 0; i < enemies.size(); i++) {

            Enemy enemy = enemies.get(i);
            if(enemy.isAlive() && word.compareTo(enemy.getWord()) == 0) {
                player.attack((Entity)enemy);
                Model.notifyPlayerAttackObservers();

                if(!enemy.isAlive()) {
                    Model.notifyEnemyDeathObservers(i);
                }
            }
        }

        System.out.println("End submit");
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

    public void addEnemy(Enemy enemy) {
        enemy.setBattle(this);
        this.enemies.add(enemy);
    }

    public void addProjectile(Enemy enemy){
        projectlist.add(enemy);
        enemy.setBattle(this);
        enemy.attack(player);
    }
}
