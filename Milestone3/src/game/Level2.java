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

public class Level2 extends GameLevel{

    public Level2(Game game) {

        super(game);

        try {
            gameMusic = new SoundClip("data/gametheme2.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }


        Shape shape = new BoxShape(15, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-0f, -11.5f));
        ground.setFillColor(Color.RED);


        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);

        platform1.setPosition(new Vec2(-9, 6.5f));
        platform1.setFillColor(Color.RED);


        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(11, 2.5f));
        platform2.setFillColor(Color.RED);

        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(11, -5.5f));
        platform4.setFillColor(Color.RED);

        Shape Platform3 = new BoxShape(5f,0.5f, new Vec2(-9f,6.5f));
        new SolidFixture(ground,Platform3);

        Shape floatingPlatform = new BoxShape(2.5f,0.5f, new Vec2(0f,6.5f));
        new SolidFixture(ground,floatingPlatform);

        Shape floatingPlatform2 = new BoxShape(2.5f,0.5f,new Vec2(-0f,18f));
        new SolidFixture(ground,floatingPlatform2);

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
        coins5.setPosition(new Vec2(0,0));

        Coins coins6 = new Coins(this);
        coins6.setPosition(new Vec2(0,10));

        Body Spike = new Spike(this);
        Spike.setPosition(new Vec2(-6, -2));
        Spike.addCollisionListener(new Destroy(this.poolie));


        getPoolie().setPosition(new Vec2(-7, -10));
        getGate().setPosition(new Vec2(-12, 7));

        getPoolie().addCollisionListener(new CoinsPickup(getPoolie()));
    }


    @Override
    public boolean isComplete() {
        if (getPoolie().getCoinCount() == 6)
            return true;
        else
            return false;
    }

    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/mars.jpg").getImage();
        return background;
    }
    @Override
    public String getLevelName(){
        return "Level2";
    }
}