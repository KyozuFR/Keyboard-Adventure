package fr.ubordeaux.ao.keyboardadventure.view;

import fr.ubordeaux.ao.mazing.view.Orientation;
import fr.ubordeaux.ao.mazing.view.entity.AnimatedEntity;
import fr.ubordeaux.ao.mazing.view.sprite.AnimatedSprites;

public class PlayerEntity extends AnimatedEntity {

    // Properties :

    // Constructors :
    public PlayerEntity() {
        super(AnimatedSprites.CRUSADER_IDLE, Orientation.SOUTH_EAST, 4, 5, 0);
    }

    // Methods :
}
