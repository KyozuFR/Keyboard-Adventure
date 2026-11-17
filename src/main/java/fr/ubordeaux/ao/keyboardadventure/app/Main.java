package fr.ubordeaux.ao.keyboardadventure.app;
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
import javax.swing.JFrame;

/**
 * Exemple minimal : un sol en pierre et un personnage animé.
 */
public final class Main {

    private static final int SCENE_SIZE = 10;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showScene);
        Enemy dummy = EnemyBuilder.baseEnemy().dummyEnemy().build();
        System.out.println(dummy.getWord());
    }

    private static void showScene() {

        // Création d'une scène automatiquement centrée.
        Scene scene = new Scene(
                800, 600,
                SCENE_SIZE, SCENE_SIZE);

        KeyboardController keyboard = new KeyboardController();
        scene.getPanel().addKeyListener(keyboard);
        scene.getPanel().setFocusable(true);

        // Ajout du sol.
        for (int x = 0; x < SCENE_SIZE; x++) {
            for (int y = 0; y < SCENE_SIZE; y++) {
                scene.addRenderable(new FloorTile(
                        IsometricSprites.STONE,
                        Orientation.NORTH,
                        x, y, 0));
            }
        }

        // Cubes de débogage.
        for (int x = 0; x < SCENE_SIZE; x++) {
            for (int y = 0; y < SCENE_SIZE; y++) {
                scene.addDebugCube(x, y, 0);
            }
        }

        // Décor statique positionné librement, avec une taille personnalisée.
        scene.addRenderable(new Entity(
                IsometricSprites.CHAIR,
                Orientation.NORTH,
                2.5, 3.75, 0.0, 1.2));

        // Personnage animé.
        scene.addRenderable(new AnimatedEntity(
                AnimatedSprites.CRUSADER_IDLE,
                Orientation.SOUTH_EAST,
                4, 5, 0));

        scene.startAnimation(24);

        // Affichage sans manipulation de JFrame.
        scene.show();

        // Terminer l'application lorsque la fenêtre est fermée.
        if (SwingUtilities.getWindowAncestor(scene.getPanel()) instanceof JFrame frame) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}

