package fr.ubordeaux.ao.keyboardadventure.app;
import fr.ubordeaux.ao.keyboardadventure.model.Battle;
import fr.ubordeaux.ao.keyboardadventure.model.Donjon;
import fr.ubordeaux.ao.keyboardadventure.model.Player;
import fr.ubordeaux.ao.keyboardadventure.model.enemy.Enemy;
import fr.ubordeaux.ao.keyboardadventure.model.enemy.EnemyBuilder;


import javax.swing.SwingUtilities;


import java.util.Arrays;
import java.util.List;

import fr.ubordeaux.ao.keyboardadventure.controller.Controller;
import fr.ubordeaux.ao.keyboardadventure.controller.KeyboardController;
import fr.ubordeaux.ao.keyboardadventure.model.Model;
import fr.ubordeaux.ao.keyboardadventure.view.GameView;

import javax.swing.*;

/**
 * Exemple minimal : un sol en pierre et un personnage animé.
 */
public final class Main {

    private static final int SCENE_SIZE = 10;

    private static final Player player = new Player(10, 10);

    public static Donjon donjon;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showScene);
        Enemy dummy = EnemyBuilder.baseEnemy().dummyEnemy().build();
        Battle battle = new  Battle(Arrays.asList(dummy,EnemyBuilder.baseEnemy().fireEnemy().build()));
        List<Battle> battles = Arrays.asList(battle);
        donjon = new Donjon(battles);
        donjon.run(player);
        System.out.println(dummy.getWord());
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

