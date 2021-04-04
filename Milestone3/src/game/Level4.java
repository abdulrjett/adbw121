package game;

import javax.swing.*;
import java.awt.*;

public class Level4 extends GameLevel {

    public Level4(Game game){
        super(game);
    }

    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/stars.png").getImage();
        return background;
    }

    @Override
    public boolean isComplete() {
        if (getPoolie().getCoinCount() == 5)
            return true;
        else
            return false;
    }
    @Override
    public String getLevelName(){
        return "Level4";
    }
}