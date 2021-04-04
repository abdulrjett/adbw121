package game;

import city.cs.engine.*;

public class Poolie extends Walker {
    private static final Shape poolieShape = new PolygonShape(0.17f,2.36f, 1.92f,0.5f, -0.22f,-1.98f, -1.83f,-1.93f, -1.79f,1.57f, -0.79f,2.42f);


    private static final BodyImage image =
            new BodyImage("data/poolie.png", 4f);

    private int CoinCount;
    private int liveCount;

    public Poolie(World world) {
        super(world, poolieShape);
        addImage(image);

        CoinCount = 0;
    }

    public void addCoins(){
        CoinCount++;
        System.out.println("Wealth Increasing: " +
                "CoinCount = " + CoinCount);
    }
    public int getCoinCount(){
        return CoinCount;
    }
    public int getLiveCount(){
        return liveCount;}

    public void decrementLiveCount(){
        liveCount--;
        System.out.println("You got hurt!. Lives = " + liveCount);
    }
    public void resetLiveCount() {
        this.liveCount = 3;
        System.out.println("Lives: " + liveCount);
    }


}