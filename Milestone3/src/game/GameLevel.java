package game;
import city.cs.engine.World;
import city.cs.engine.SoundClip;

import java.awt.*;

public abstract class GameLevel extends World {
    public Poolie poolie;
    private final Gate gate;
    public SoundClip gameMusic;

    public GameLevel(Game game){
        //all levels have a student, a professor
        //and the student needs to reach the professor
        //to complete the game (hence a ProfessorEncounter)
        poolie = new Poolie(this);
        gate = new Gate(this);
        GateEncounter encounter = new GateEncounter(this, game);
        poolie.addCollisionListener(encounter);
    }
    public  void setPoolie(Poolie s){
        poolie = s;
    };

    public Poolie getPoolie(){
        return poolie;
    }
    public Gate getGate() { return  gate; }
    public abstract boolean isComplete();
    public abstract Image paintBackground();
    public SoundClip getGameMusic(){return gameMusic;}
    public abstract  String getLevelName();


}