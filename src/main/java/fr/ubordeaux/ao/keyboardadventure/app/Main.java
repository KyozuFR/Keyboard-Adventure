package fr.ubordeaux.ao.keyboardadventure.app;
import fr.ubordeaux.ao.keyboardadventure.view.GameView;
import fr.ubordeaux.ao.keyboardadventure.model.enemy.Enemy;
import fr.ubordeaux.ao.keyboardadventure.model.enemy.EnemyBuilder;
import fr.ubordeaux.ao.mazing.Scene;
import fr.ubordeaux.ao.mazing.view.Orientation;
import fr.ubordeaux.ao.mazing.view.entity.AnimatedEntity;
import fr.ubordeaux.ao.mazing.view.entity.Entity;
import fr.ubordeaux.ao.mazing.view.entity.FloorTile;
import fr.ubordeaux.ao.mazing.view.sprite.AnimatedSprites;
import fr.ubordeaux.ao.mazing.view.sprite.IsometricSprites;
import fr.ubordeaux.ao.keyboardadventure.controller.KeyboardController;

import javax.swing.SwingUtilities;

/**
 * Exemple minimal : un sol en pierre et un personnage animé.
 */
public final class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showScene);
        Enemy dummy = EnemyBuilder.baseEnemy().dummyEnemy().build();
        System.out.println(dummy.getWord());
    }

    private static void showScene() {
        GameView view = new GameView();
    }
}

