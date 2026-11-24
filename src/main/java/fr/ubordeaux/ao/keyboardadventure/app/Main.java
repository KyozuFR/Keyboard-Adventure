package fr.ubordeaux.ao.keyboardadventure.app;
import fr.ubordeaux.ao.keyboardadventure.controller.Controller;
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
import fr.ubordeaux.ao.keyboardadventure.model.Model;

import javax.swing.*;
import javax.swing.SwingUtilities;

/**
 * Exemple minimal : un sol en pierre et un personnage animé.
 */
public final class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showScene);
    }

    private static void showScene() {
        Model model = new Model();
        GameView view = new GameView();
        Controller controller = new Controller(view, model);
        KeyboardController keyboardController = new KeyboardController(controller);

        JTextArea area = new JTextArea();
        area.addKeyListener(keyboardController);
        view.getPanel().add(area);
        model.addObserver(view);
        System.out.println("Fait");
    }
}

