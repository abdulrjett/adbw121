package game;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Poolie poolie;
    public Tracker(GameView view, Poolie poolie) {
        this.view = view;
        this.poolie = poolie;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(poolie.getPosition()));
    }
}