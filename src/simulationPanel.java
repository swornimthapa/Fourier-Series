import Inputs.keyInputs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.*;

public class simulationPanel extends JPanel implements Runnable{
    int circleX=0 , circleY=0;

    double time=0;
    double frames=120;
    int numberOFEpicircles=0;
    ArrayList<Integer> array= new ArrayList<Integer>();
    public simulationPanel(){


           this.setPreferredSize(new Dimension(1500,500));
           this.setLayout(null);
            this.setDoubleBuffered(true);
            this.setBackground(Color.BLACK);
            Thread thread=new Thread(this);
            thread.start();

    }



    @Override
    protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            numberOFEpicircles = 100;
            int preCircleX = 0, preCircleY = 0;
            int n = 0;
            double x = 0, y = 0;
            int radius = 0;
            preCircleX = circleX;
            preCircleY = circleY;
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(300, 250);
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

            for (int i = 0; i < numberOFEpicircles; i++) {

                n = i * 2 + 1;
                radius = (int) (80 * (4 / (n * PI)));

                x += (radius * cos(n * time));
                y += (radius * sin(n * time));
                g.setColor(Color.white.darker().darker().darker());
                g.drawOval((int) preCircleX - radius, (int) preCircleY - radius, radius * 2, radius * 2);
                g.setColor(Color.magenta);
                g.drawLine((int) (preCircleX), (int) (preCircleY), (int) x, (int) y);

                preCircleX = (int) x;
                preCircleY = (int) y;


            }
            array.add(0, (int) y);
            g.drawLine((int) x, (int) y, (int) 200, (int) y);
            g2d.translate(200, 0);
            for (int j = 0; j < array.size(); j++) {

                if(j== array.size()-1){
                    g.drawLine(j,array.get(j), j,array.get(j));
                }else {
                    g.drawLine(j,array.get(j), j,array.get(j+1));
                }

            }
            if (array.size() == 700) {
                array.remove(array.size() - 1);
            }
            time = time + 0.03;


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
