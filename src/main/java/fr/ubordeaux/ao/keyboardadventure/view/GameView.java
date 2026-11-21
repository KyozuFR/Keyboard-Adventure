package fr.ubordeaux.ao.keyboardadventure.view;

import fr.ubordeaux.ao.keyboardadventure.model.Observer;
import fr.ubordeaux.ao.mazing.Scene;
import fr.ubordeaux.ao.mazing.view.Orientation;
import fr.ubordeaux.ao.mazing.view.entity.AnimatedEntity;
import fr.ubordeaux.ao.mazing.view.entity.FloorTile;
import fr.ubordeaux.ao.mazing.view.sprite.AnimatedSprites;
import fr.ubordeaux.ao.mazing.view.sprite.IsometricSprites;

import javax.swing.*;

public class GameView extends View implements Observer {
    private static final int SCENE_SIZE = 10;
    private final Scene scene;

    public GameView() {
        scene = new Scene(
                800, 600,
                SCENE_SIZE, SCENE_SIZE);
        floor();

        // Personnage animé.
        scene.addRenderable(new AnimatedEntity(
                AnimatedSprites.CRUSADER_IDLE,
                Orientation.SOUTH_EAST,
                4, 5, 0));
        scene.startAnimation(24);
        scene.show();
    }

    private void floor(){
        // Ajout du sol.
        for (int x = 0; x < SCENE_SIZE; x++) {
            for (int y = 0; y < SCENE_SIZE; y++) {
                scene.addRenderable(new FloorTile(
                        IsometricSprites.STONE,
                        Orientation.NORTH,
                        x, y, 0));
            }
        }
    }

    public JPanel getPanel() {
        return scene.getPanel();
    }


    @Override
    public void update() {
        // TODO
    }
}
