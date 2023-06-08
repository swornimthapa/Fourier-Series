import Inputs.keyInputs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.*;

public class simulationPanel extends JPanel implements Runnable{
    int circleX=0 , circleY=0;

    keyInputs keyboradInputs;


    double time=0;
    double frames=120;
    int numberOFEpicircles=0;
    ArrayList<Integer> array= new ArrayList<Integer>();
    public simulationPanel(){
            this.setPreferredSize(new Dimension(1500,500));
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
        numberOFEpicircles=20;
      //  int preCircleX, preCircleY=0;
        int n=0;
        int preX=0,preY=0;
        double x=0,y=0;
        int radius=0;
       // preCircleX=circleX;
       // preCircleY=circleY;

        Graphics2D g2d=(Graphics2D) g;
        g2d.translate(200,250);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));
        g.setColor(Color.black);

        for(int i=0;i<numberOFEpicircles;i++) {

            n=i*2+1;
            radius= (int) (80 * (4 / (n * PI)));

            x+=(radius *cos(n*time)) ;
            y+=(radius *sin(n*time)) ;

            g.drawOval((int) circleX-radius, (int) circleY-radius, radius*2 , radius*2);
            g.drawLine((int) (circleX), (int) (circleY), (int) x-preX, (int)y-preY);


            g2d.translate(x-preX,y-preY);
            preX= (int) x;
            preY= (int) y;
//            preCircleX=0;
//            preCircleY= 0;


        }
        array.add( (int) y);
         g2d.translate(-x,-y);
        int capacity=array.size();
        g.drawLine((int) x, (int) y, (int) 200, (int) array.get(capacity-1));
        g2d.translate(200,0);

        for(int j=0;j<array.size();j++) {

            g.drawOval((int) j, (int) array.get(j), 1, 1);


        }


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
