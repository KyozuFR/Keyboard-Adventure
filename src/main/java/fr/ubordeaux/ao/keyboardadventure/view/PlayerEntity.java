package fr.ubordeaux.ao.keyboardadventure.view;

import fr.ubordeaux.ao.mazing.view.Orientation;
import fr.ubordeaux.ao.mazing.view.entity.AnimatedEntity;
import fr.ubordeaux.ao.mazing.view.sprite.AnimatedSprites;

public class PlayerEntity extends AnimatedEntity {

    // Properties :

    // Constructors :
    public PlayerEntity() {
        this(10, 4, 0);
    }

    public PlayerEntity(int xPosition, int yPosition, int zPosition) {
        super(AnimatedSprites.CRUSADER_IDLE, Orientation.NORTH, xPosition, yPosition, zPosition);
    }



    // Methods :
    public void setIdleAnimation() {
        setSprite(AnimatedSprites.CRUSADER_IDLE);
    }

    public void setAttackAnimation() {
        setSprite(AnimatedSprites.CRUSADER_ATTACK);
    }
}
