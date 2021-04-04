package game;

import city.cs.engine.*;

public class Gate extends Walker {

    private static final Shape gateShape = new PolygonShape(
            -1.76f,2.33f, 1.61f,2.38f, 1.64f,-2.26f, -1.74f,-2.3f);


    private static final BodyImage image =
            new BodyImage("data/gate.png", 4f);


    public Gate(World world) {
        super(world, gateShape);
        addImage(image);
    }
}