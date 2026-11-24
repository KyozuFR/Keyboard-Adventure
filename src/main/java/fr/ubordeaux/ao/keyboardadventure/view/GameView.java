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

    // Constants :
    private static final int SCENE_SIZE = 20;

    // Properties :
    private final Scene scene;
    private PlayerEntity player;

    // Constructors :
    public GameView() {
        this.scene = new Scene(
                800, 600,
                SCENE_SIZE, SCENE_SIZE);
        floor();

        // Personnage :
        this.player = new PlayerEntity(10, 7, 0);
        scene.addRenderable(player);
        scene.startAnimation(24);
        scene.show();
    }

    // Methods :
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

    @Override
    public void updateStartBattle(int n) {
        for(int i = 0; i < n; i++) {
            EnemyEntity entity = new EnemyEntity(7+i, 20, 0);
            entity.move(0, -8);
            scene.addRenderable(entity);
        }
    }

}