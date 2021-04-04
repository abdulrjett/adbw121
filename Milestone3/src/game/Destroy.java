package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class Destroy implements CollisionListener {
    private Poolie poolie;

    public Destroy(Poolie poolie) {
        this.poolie = poolie;
    }

    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == this.poolie) {
            this.poolie.decrementLiveCount();
            if (poolie.getLiveCount() == 0) {
                poolie.destroy();
            }
            e.getReportingBody().destroy();

        }
        if (poolie.getLiveCount() == 0){
            System.out.println("No more Lives.Try Again!.");
            poolie.resetLiveCount();
            poolie.setPosition(new Vec2(-9, -10));
        }
    }
}