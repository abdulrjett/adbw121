package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CoinsPickup implements CollisionListener {

    private Poolie poolie;
    public CoinsPickup(Poolie s){
        this.poolie = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coins) {
            poolie.addCoins();
            e.getOtherBody().destroy();


        }
    }
}