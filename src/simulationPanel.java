import Inputs.keyInputs;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public class simulationPanel extends JPanel implements Runnable{
    int circleX=0 , circleY=0;
    double x=0,y=0;
    keyInputs keyboradInputs;
    int radius=0;

    double time=0;
    double frames=120;
    int numberOFEpicircles=0;
    public simulationPanel(){
            this.setPreferredSize(new Dimension(900,700));
            this.setDoubleBuffered(true);

            keyboradInputs=new keyInputs();
            addKeyListener(keyboradInputs);
            this.setFocusable(true);


//        circleX= circleX-radius;
//        circleY= circleY-radius;

            Thread thread=new Thread(this);
            thread.start();



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.translate(200,250);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));

       // int radius= (int) (4/PI);
        numberOFEpicircles=3;
        int preCircleX, preCircleY=0;
        int n=0;

        preCircleX=circleX;
        preCircleY=circleY;
       // preRadius=radius;
        g.setColor(Color.black);
        for(int i=0;i<numberOFEpicircles;i++) {

            n=i*2+1;
            radius= (int) (100 * (4 / (n * PI)));
            x=(radius *cos(n*time)) ;
            y=(radius *sin(n*time)) ;


            g.drawOval((int) preCircleX-radius, (int) preCircleY-radius, radius * 2, radius* 2);
            g.drawLine((int) (preCircleX), (int) (preCircleY), (int) x, (int)y);

            g2d.translate(x,y);
//            preCircleX= (int) x;
//            preCircleY= (int) y;

            preCircleX=0;
            preCircleY= 0;

        }

        //g.drawOval((int)circleX,(int)circleY,radius*2,radius*2);
        time=time+0.02;

    }


    @Override
    public void run() {
        double frameperTime= 1000000000.0/frames;
        long lastTime=System.nanoTime();
        while(true){
            long currentTime=System.nanoTime();
            if(currentTime-lastTime>=frameperTime){
                repaint();
                lastTime=currentTime;
            }
        }
    }
}
