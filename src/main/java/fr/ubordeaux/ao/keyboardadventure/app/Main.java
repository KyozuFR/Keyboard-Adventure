package fr.ubordeaux.ao.keyboardadventure.app;
import fr.ubordeaux.ao.keyboardadventure.controller.Controller;
import fr.ubordeaux.ao.keyboardadventure.controller.KeyboardController;
import fr.ubordeaux.ao.keyboardadventure.model.Model;
import fr.ubordeaux.ao.keyboardadventure.view.GameView;

import javax.swing.*;

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

