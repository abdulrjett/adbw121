package game;

import city.cs.engine.*;

public class Spike extends DynamicBody {
    private static final Shape spikeshape = new BoxShape(1,0.5f);
    private static final BodyImage spikeImage = new BodyImage("data/spikes.png",0.4f);

    public Spike(GameLevel Level2) {
        super (Level2,spikeshape);
        addImage(spikeImage);
    }
}