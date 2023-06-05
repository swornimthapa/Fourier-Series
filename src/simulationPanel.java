import Inputs.keyInputs;

import javax.swing.*;
import java.awt.*;

public class simulationPanel extends JPanel implements Runnable{
    int circleX=100 , circleY=100;
    keyInputs keyboradInputs;
    double frames=120;
    public simulationPanel(){
            this.setPreferredSize(new Dimension(900,700));
            this.setDoubleBuffered(true);

            keyboradInputs=new keyInputs();
            addKeyListener(keyboradInputs);
            this.setFocusable(true);

            Thread thread=new Thread(this);
            thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));
        g.setColor(Color.black);
        g.drawOval(circleX,circleY,100,100);

        g.drawOval(circleX+50-25,circleY+50-25,50,50);

    }
    private void update(){
        if(keyboradInputs.up){
            circleY=circleY-5;
            System.out.println("upup");
        }
        if(keyboradInputs.down){
            circleY= circleY+5;
        }
        if(keyboradInputs.left){
            circleX=circleX-5;
        }
        if(keyboradInputs.right){
            circleX=circleX+5;
        }
    }

    @Override
    public void run() {
        double frameperTime= 1000000000.0/frames;
        long lastTime=System.nanoTime();
        while(true){
            long currentTime=System.nanoTime();
            if(currentTime-lastTime>=frameperTime){
                update();
                repaint();
                lastTime=currentTime;
            }
        }
    }
}
