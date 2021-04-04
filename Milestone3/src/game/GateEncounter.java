package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class GateEncounter implements CollisionListener {

    private final GameLevel level;
    private final Game game;

    public GateEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //if student collided with professor and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Gate
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}

