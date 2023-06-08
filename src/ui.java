import javax.swing.*;
import java.awt.*;

public class ui {
    JSlider slider;
    JPanel topPanel;
    JLabel label;
    simulationPanel panel;
    public ui(){
        initializeComponents();
    }

    private void initializeComponents() {

        topPanel=new JPanel();
        topPanel.setBackground(Color.white);
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(1500,100));

        panel=new simulationPanel();

        slider=new JSlider();
        slider.setMaximum(100);
        slider.setMinimum(0);
        slider.setBounds(600,20,250,50);
        slider.setBackground(Color.black);
        //slider.setForeground(Color.magenta);
        topPanel.add(slider);
    }
}
