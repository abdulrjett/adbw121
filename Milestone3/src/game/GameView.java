package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class GameView extends UserView {
    public Image screen;
    public GameView(World w, int width, int height) {
        super(w, width, height);
    }


    public void setScreen(Image b){
        this.screen =b;
    }


    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(screen, 0, 0, this);
    }




}
