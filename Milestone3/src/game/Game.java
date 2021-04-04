package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

public class Game {

    private GameLevel level;

    private GameView view;

    private SoundClip gameMusic;
    private PoolieController controller;

    public Game() {

        //Looped Background Music
        level = new Level1(this);


        //Creates view
        view = new GameView(level, 570, 590);
        view.setZoom(20);
        view.setScreen(level.paintBackground());
        //Engineer View
        //JFrame debugView = new DebugViewer(level, 600, 600);
        //view.setGridResolution(1);

        view.addMouseListener(new GiveFocus(view));

        controller = new PoolieController(level.getPoolie());
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

        //view to frame
        final JFrame frame = new JFrame("Pools Adventure");
        frame.add(view);

        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.WEST);

        //Allows frame to quit application when x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        //Makes sure frame cannot be resized
        frame.setResizable(false);
        //sizes frame to fir world view
        frame.pack();
        //Visible frame
        frame.setVisible(true);
        level.start();
    }

    public void goToNextLevel(){

        if (level instanceof Level1){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level.gameMusic.pause();
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            view.setZoom(20);
            view.setScreen(level.paintBackground());
            //change the controller to control the
            //student in the new world
            controller.updatePoolie(level.getPoolie());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level2){
            level.stop();
            level = new Level3(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setScreen(level.paintBackground());
            controller.updatePoolie(level.getPoolie());
            level.start();
        }
        else if (level instanceof Level3){
            level.stop();
            level = new Level4(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setScreen(level.paintBackground());
            controller.updatePoolie(level.getPoolie());
            level.start();
        }

}

    public void restartLevel() {
        if (level instanceof Level1) {
            level.stop();
            level.gameMusic.pause();
            level = new Level1(this);

            view.setWorld(level);
            view.setZoom(20);
            view.setScreen(level.paintBackground());

            controller.updatePoolie(level.getPoolie());
            level.start();
        } else if (level instanceof Level2) {
            level.stop();
            level.gameMusic.pause();
            level = new Level2(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setScreen(level.paintBackground());


            controller.updatePoolie(level.getPoolie());
            level.start();
        }
    }
        public void pause () {
            level.stop();
        }
        public void unpause () {
            level.start();
        }

        public GameLevel getLevel () {
            return level;
        }
        public void setLevel ( int i){
            if (i == 1) {
                level = new Level1(this);
                restartLevel();

            } else if (i == 2) {
                level = new Level2(this);
                restartLevel();

            } else if (i == 3) {
                level = new Level3(this);
                restartLevel();

            } else if (i == 4) {
                level = new Level4(this);
                restartLevel();
            }
        }


            public void setLevelAlt (GameLevel level){

                //stop the current level
                this.level.stop();
                this.level.gameMusic.pause();

                //create the new (appropriate) level
                //level now refers to new level
                this.level = level;


                //change the view to look into new level

                view.setWorld(level);
                view.setZoom(10);
                view.setScreen(level.paintBackground());
                //change the controller to control the
                //student in the new world
                controller.updatePoolie(level.getPoolie());
                //start the simulation in the new level
                level.start();

            }



        public static void main (String[]args){
            new Game();

        }

    }