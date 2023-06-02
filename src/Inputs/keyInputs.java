package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyInputs implements KeyListener {
    public boolean up=false,down=false,left=false,right=false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_UP){
            up=true;
        }
        if(keycode==KeyEvent.VK_DOWN){
            down=true;
        }
        if(keycode==KeyEvent.VK_LEFT){
            left=true;
        }
        if(keycode==KeyEvent.VK_RIGHT){
            right=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keycode=e.getKeyCode();
        if(keycode==KeyEvent.VK_UP){
            up=false;
        }
        if(keycode==KeyEvent.VK_DOWN){
            down=false;
        }
        if(keycode==KeyEvent.VK_LEFT){
            left=false;
        }
        if(keycode==KeyEvent.VK_RIGHT){
            right=false;
        }
    }
}
