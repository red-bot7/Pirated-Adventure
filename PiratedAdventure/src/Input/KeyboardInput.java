package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener{

    public boolean up = false, down  = false, left  = false, right  = false;
    public boolean isMoving = false;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            up = true;
            isMoving = true;
        } else if(e.getKeyCode() == KeyEvent.VK_S) {
            down = true;
            isMoving = true;
        } else if(e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
            isMoving = true;
        } else if(e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
            isMoving = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            up = false;
            isMoving = false;
        } else if(e.getKeyCode() == KeyEvent.VK_S) {
            down = false;
            isMoving = false;
        } else if(e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
            isMoving = false;
        } else if(e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
            isMoving = false;
        }
    }
    
}
