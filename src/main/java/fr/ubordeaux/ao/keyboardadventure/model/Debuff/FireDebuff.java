package fr.ubordeaux.ao.keyboardadventure.model.Debuff;

import fr.ubordeaux.ao.keyboardadventure.model.Entity;

import java.util.Timer;
import java.util.TimerTask;

public class FireDebuff implements Debuff{
    static final int nbEffect = 3;
    static final int DAMAGE = 5;
    //ms
    static final int DELAY = 1000;

    @Override
    public void applyEffect(Entity entity){
        for(int i = nbEffect;i>0;i--){
            Timer timer = new Timer("fireDebuff Timer");
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        entity.hurt(DAMAGE);
                    } finally {
                        timer.cancel();
                    }
                }
            }, DELAY);
        }
    }
}
