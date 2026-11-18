package fr.ubordeaux.ao.keyboardadventure.app;
import fr.ubordeaux.ao.keyboardadventure.view.GameView;

import javax.swing.SwingUtilities;

/**
 * Exemple minimal : un sol en pierre et un personnage animé.
 */
public final class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showScene);
    }

    private static void showScene() {
        GameView view = new GameView();
    }
}

