package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Coins;
import game.CoinsPickup;
import game.Game;
import game.GameLevel;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level3 extends GameLevel {

    public Level3(Game game) {
        super(game);


        city.cs.engine.Shape shape = new BoxShape(15, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-0f, -11.5f));
        ground.setFillColor(Color.RED);


        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
       // platform1.setPosition();


        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(11, 7.5f));
        platform2.setFillColor(Color.BLUE);


        Shape platform3 = new BoxShape(5f, 0.5f, new Vec2(-9f, 13.5f));
        new SolidFixture(ground, platform3);


        Shape floatingPlatform = new BoxShape(2.5f, 0.5f, new Vec2(0f, 6.5f));
        new SolidFixture(ground, floatingPlatform);

        Shape floatingPlatform2 = new BoxShape(2.5f, 0.5f, new Vec2(-0f, 18f));
        new SolidFixture(ground, floatingPlatform2);

        Shape leftWallShape = new BoxShape(0.5f, 16, new Vec2(-13.5f, 10f));
        new SolidFixture(ground, leftWallShape);

        Shape rightWallShape = new BoxShape(0.5f, 17, new Vec2(14.f, 10f));
        new SolidFixture(ground, rightWallShape);

        Shape ceilingShape = new BoxShape(16f, 0.5f, new Vec2(-1.95f, 26));
        new SolidFixture(ground, ceilingShape);


        Coins coins1 = new Coins(this);
        coins1.setPosition(new Vec2(-10, 7));

        Coins coins2 = new Coins(this);
        coins2.setPosition(new Vec2(10, 5));

        Coins coins3 = new Coins(this);
        coins3.setPosition(new Vec2(-13, 0));

        Coins coins4 = new Coins(this);
        coins4.setPosition(new Vec2(10, -2));

        Coins coins5 = new Coins(this);
        coins5.setPosition(new Vec2(0, 0));

        Coins coins6 = new Coins(this);
        coins6.setPosition(new Vec2(0, 10));

        Body Spike = new Spike(this);
        Spike.setPosition(new Vec2(-6, -2));
        Spike.addCollisionListener(new Destroy(this.poolie));


        getPoolie().setPosition(new Vec2(-7, -10));
        getGate().setPosition(new Vec2(-12, 7));

        getPoolie().addCollisionListener(new CoinsPickup(getPoolie()));

}




    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/utopia.png").getImage();
        return background;
    }

    @Override
    public boolean isComplete() {
        if (getPoolie().getCoinCount() == 7)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName(){
        return "Level3";
    }
}
