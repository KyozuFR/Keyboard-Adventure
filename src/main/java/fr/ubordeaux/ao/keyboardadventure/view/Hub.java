package fr.ubordeaux.ao.keyboardadventure.view;

import fr.ubordeaux.ao.keyboardadventure.model.Observer;
import fr.ubordeaux.ao.mazing.Scene;
import fr.ubordeaux.ao.mazing.view.Orientation;
import fr.ubordeaux.ao.mazing.view.entity.FloorTile;
import fr.ubordeaux.ao.mazing.view.sprite.IsometricSprites;

import java.util.List;

public class Hub extends View implements Observer {

    // Constants :
    private static final int SCENE_SIZE = 20;

    // Properties :
    private final Scene scene;
    private PlayerEntity player;

    public Hub(Scene scene) {
        this.scene = new Scene(800, 600, SCENE_SIZE, SCENE_SIZE);
        floor();
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

    @Override
    public void update() {

    }

    @Override
    public void updateStartBattle(int n, List<String> enemyLabels) {

    }

    @Override
    public void updateEnemyDeath(int index) {

    }

    @Override
    public void updateEnemyAttack(int index) {

    }

    @Override
    public void updatePlayerAttack() {

    }
}
