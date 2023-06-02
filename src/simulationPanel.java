import Inputs.keyInputs;

import javax.swing.*;
import java.awt.*;

public class simulationPanel extends JPanel {
    int recX=100 , recY=100;
    keyInputs keyboradInputs;
    public simulationPanel(){
            keyboradInputs=new keyInputs();
            addKeyListener(keyboradInputs);
            this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(recX,recY,100,100);
        update();

    }
    private void update(){
        if(keyboradInputs.up){
            recY=recY-5;
            System.out.println("upup");
        }
        if(keyboradInputs.down){
            recY=recY+5;
        }
        if(keyboradInputs.left){
            recX=recX-5;
        }
        if(keyboradInputs.down){
            recX=recX+5;
        }
        repaint();
    }
}
