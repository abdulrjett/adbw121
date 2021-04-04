package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PoolieController implements KeyListener {

    private static final float WALKING_SPEED = 4;

    private Poolie poolie;

    public PoolieController(Poolie s){
        poolie = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            poolie.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            poolie.startWalking(WALKING_SPEED);
        }
          else if (code == KeyEvent.VK_W){
            poolie.jump(10);
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            poolie.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            poolie.stopWalking();

        }
    }
    public void updatePoolie(Poolie poolie){this.poolie = poolie;}
}
