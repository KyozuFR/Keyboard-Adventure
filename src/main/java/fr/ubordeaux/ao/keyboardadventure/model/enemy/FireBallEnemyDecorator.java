package fr.ubordeaux.ao.keyboardadventure.model.enemy;

import java.util.Timer;
import java.util.TimerTask;

import fr.ubordeaux.ao.keyboardadventure.model.debuff.FireDebuff;
import fr.ubordeaux.ao.keyboardadventure.model.Entity;
public class FireBallEnemyDecorator extends EnemyDecorator{
 //ms
    static final long DELAY = 5000;
//stinky
    static final int DAMAGE = 1;

    public FireBallEnemyDecorator(Enemy enemy){
        super(enemy);
    }

    @Override
    public void attack(Entity entity){
        Timer timer = new Timer("FireBall Timer");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    entity.hurt(DAMAGE);
                    entity.addDebuff(new FireDebuff());
                } finally {
                    timer.cancel();
                }
            }
        }, DELAY);
        die();
    }
}
