package fr.ubordeaux.ao.keyboardadventure.view;

import fr.ubordeaux.ao.mazing.view.Orientation;
import fr.ubordeaux.ao.mazing.view.entity.AnimatedEntity;
import fr.ubordeaux.ao.mazing.view.sprite.AnimatedSprites;

public class EnemyEntity extends AnimatedEntity {

    // Properties :
    private String word;

    // Constructors :
    public EnemyEntity() {
        this(4, 5, 0);
    }
    public EnemyEntity(int xPosition, int yPosition, int zPosition) {
        super(AnimatedSprites.SPIDER_WALK, Orientation.SOUTH, xPosition, yPosition, zPosition);
    }

    // Methods :
    public void setAttackAnimation() {
        setSprite(AnimatedSprites.SPIDER_ATTACK);
    }

    public void setDeathAnimation() {
        setSprite(AnimatedSprites.SPIDER_DEATH);
    }

    public void setWalkAnimation() {
        setSprite(AnimatedSprites.SPIDER_WALK);
    }
}
