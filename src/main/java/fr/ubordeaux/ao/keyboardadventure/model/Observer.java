package fr.ubordeaux.ao.keyboardadventure.model;

public interface Observer {
    void update();

    void updateStartBattle(int n);

    void updateEnemyDeath(int index);

    void updateEnemyAttack(int index);

    void updatePlayerAttack();
}
