package fr.ubordeaux.ao.keyboardadventure.model;

import java.util.List;

public interface DonJonObserver extends Observer {

    void updateStartBattle(int n, List<String> enemyLabels);

    void updateEnemyDeath(int index);

    void updateEnemyAttack(int index);

    void updatePlayerAttack();
}
