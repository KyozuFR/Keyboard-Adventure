package fr.ubordeaux.ao.keyboardadventure.view;

import fr.ubordeaux.ao.keyboardadventure.model.Observer;
import fr.ubordeaux.ao.mazing.Scene;
import fr.ubordeaux.ao.mazing.view.Orientation;
import fr.ubordeaux.ao.mazing.view.Point;
import fr.ubordeaux.ao.mazing.view.entity.AnimatedEntity;
import fr.ubordeaux.ao.mazing.view.entity.FloorTile;
import fr.ubordeaux.ao.mazing.view.renderer.IsometricRenderer;
import fr.ubordeaux.ao.mazing.view.sprite.AnimatedSprites;
import fr.ubordeaux.ao.mazing.view.sprite.IsometricSprites;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameView extends View implements Observer {

    // Constants :
    private static final int SCENE_SIZE = 10;
    private static final int ZOOM = 2;
    private static final boolean DEBUG = true;

    // Properties :
    private final Scene scene;
    private PlayerEntity player;
    private List<EnemyEntity> enemies;
    private List<Label> enemyLabels;
    private IsometricRenderer renderer;

    // Constructors :
    public GameView() {
        this.renderer = new IsometricRenderer(0, 0);
        this.renderer.setDebug(DEBUG);
        this.renderer.setZoom(ZOOM);

        this.scene = new Scene(800, 600, SCENE_SIZE, SCENE_SIZE);
        scene.setDebug(DEBUG);

        getPanel().setLayout(null);

        floor();

        // Player :
        this.player = new PlayerEntity(5, 2, 0);
        scene.addRenderable(player);
        scene.startAnimation(24);
        scene.setZoom(ZOOM);
        scene.show();

        this.enemies = new ArrayList<>();
        this.enemyLabels = new ArrayList<>();
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

    private void cleanEntity() {
        for(EnemyEntity entity : enemies) {
            scene.removeRenderable(entity);
        }
        enemies.clear();

        for(Label label : enemyLabels) {
            getPanel().remove(label);
        }
        enemyLabels.clear();
    }

    private void addEnemies(int n) {
        for(int i = 0; i < n; i++) {
            EnemyEntity entity = new EnemyEntity(4+i, 12, 0);
            scene.addRenderable(entity);
            enemies.add(entity);

            for(int j = 0; j < 24; j++) {
                entity.moveInDirection(0, -0.25);
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (Exception e) {

                }
            }
        }
    }

    private void addLabels(int n, List<String> words) {
        for(int i = 0; i < n; i++) {
            EnemyEntity entity = enemies.get(i);
            String word = words.get(i);

            Label label = new Label(word, 15);
            FontMetrics metrics = getPanel().getFontMetrics(label.getFont());

            // On ne comprends pas pourquoi il faut rajouter ces +3 et -7 mais sans eux la projection ne les place pas bien
            Point position = renderer.projectWorld(entity.getX() + 3, entity.getY() - 7, entity.getZ());
            label.setBounds(position.x(), position.y(), metrics.stringWidth(words.get(i)), metrics.getHeight());

            enemyLabels.add(label);
            getPanel().add(label);
        }
    }

    @Override
    public void updateStartBattle(int n, List<String> words) {
        cleanEntity();
        addEnemies(n);
        addLabels(n, words);
    }

    @Override
    public void updateEnemyDeath(int index) {
        EnemyEntity entity = enemies.get(index);
        entity.setDeathAnimation();

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {

        }

        // On remove son mot
        Label label = enemyLabels.get(index);
        enemyLabels.remove(label);
        getPanel().remove(label);
        
        // On remove la spider
        enemies.remove(entity);
        scene.removeRenderable(entity);
    }

    @Override
    public void updateEnemyAttack(int index) {
        EnemyEntity entity = enemies.get(index);
        entity.setAttackAnimation();
        player.setHitAnimation();

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {

        }

        entity.setWalkAnimation();
        player.setIdleAnimation();
    }

    @Override
    public void updatePlayerAttack() {
        player.setAttackAnimation();

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) {

        }

        player.setIdleAnimation();
    }

}