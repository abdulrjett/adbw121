package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level1 extends GameLevel {

    public Level1(Game game) {
        super(game);

        try {
            gameMusic = new SoundClip("data/gametheme.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        getPoolie().setPosition(new Vec2(-9, -10));
        getGate().setPosition(new Vec2(-11, 12));

        getPoolie().addCollisionListener(new CoinsPickup(getPoolie()));

        //ground
        Shape shape = new BoxShape(15, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.setFillColor(Color.RED);

        //platforms
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 6.5f));
        platform1.setFillColor(Color.RED);


        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(5, 2.5f));
        platform2.setFillColor(Color.RED);


        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-9, -2.5f));
        platform3.setFillColor(Color.RED);


        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(5, -5.5f));
        platform4.setFillColor(Color.RED);

        //ceiling and walls
        Shape leftWallShape = new BoxShape(0.5f,16,new Vec2(-13.5f,10f));
        new SolidFixture(ground, leftWallShape);

        Shape rightWallShape = new BoxShape(0.5f,16,new Vec2(9.5f,10f));
        new SolidFixture(ground,rightWallShape);

        Shape ceilingShape = new BoxShape(12f,0.5f,new Vec2(-1.95f,26));
        new SolidFixture(ground,ceilingShape);

        //coins
        Coins coins1 = new Coins(this);
        coins1.setPosition(new Vec2(-7, 7));

        Coins coins2 = new Coins(this);
        coins2.setPosition(new Vec2(5, 5));

        Coins coins3 = new Coins(this);
        coins3.setPosition(new Vec2(-10, 0));

        Coins coins4 = new Coins(this);
        coins4.setPosition(new Vec2(5, -2));




    }
    @Override
    public boolean isComplete() {
        if (getPoolie().getCoinCount() == 4)
            return true;
        else
            return false;
    }

    @Override
    public Image paintBackground() {
        Image background = new ImageIcon("data/stars.jpg").getImage();
        return background;

    }
    @Override
    public String getLevelName(){
        return "Level1";
    }

    /*@Override
    public Image paintBackground() {
        return null;
    }*/
}
