package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.lang.module.InvalidModuleDescriptorException;

public class Coins extends DynamicBody {

    private static final Shape coinsShape = new CircleShape(1);

    private static SoundClip coinsSound;
    static {
        try {
            coinsSound = new SoundClip("data/coinsound.wav");
            System.out.println("Loading coins sound");
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    private static final BodyImage image =
            new BodyImage("data/coin.png", 2f);

    public Coins(World w) {
        super(w, coinsShape);
        addImage(image);


    }

    @Override
    public void destroy()
    {
        coinsSound.play();
        super.destroy();
    }
}


