package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import game.*;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    public static void save(GameLevel level, String fileName)
            throws IOException
    {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName()  + "\n" );
            for (StaticBody body :level.getStaticBodies()){
            }
            for (DynamicBody body :level.getDynamicBodies()){
                if (body instanceof Poolie){
                    writer.write("poolie,"+body.getPosition().x + "," +body.getPosition().y +
                            "," + ((Poolie) body).getLiveCount() + "\n" );

                }
                else if (body instanceof Spike){
                    writer.write("spikes,"+body.getPosition().x +"," +body.getPosition().y+"\n");
                }
                else if (body instanceof Coins){
                    writer.write("coins,"+body.getPosition().x+","+body.getPosition().y+"\n");
                }
            }

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static GameLevel load(Game game, String fileName) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();


            GameLevel level = null;
            if (line.equals("Level1")) {
                level = new Level1(game);
            } else if (line.equals("Level2")) {
                level = new Level2(game);
            } else if (line.equals("Level3")) {
                level = new Level3(game);
            } else if (line.equals("Level4")) {
                level = new Level3(game);
            }

            line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(",");

                if (tokens[0].equals("poolie")) {
                    Poolie s = new Poolie(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    s.setPosition(new Vec2(x, y));
                    int wc = Integer.parseInt(tokens[3]);
                    int lives = Integer.parseInt(tokens[4]);

                    level.setPoolie(s);
                    CoinsPickup pickup2 = new CoinsPickup(s);
                    s.addCollisionListener(pickup2);
                    GateEncounter gateEncounter = new GateEncounter(level, game);
                    s.addCollisionListener(gateEncounter);

                    line = reader.readLine();
                }


                return level;


            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        return null;
    }
}


