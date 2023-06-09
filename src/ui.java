import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ui implements ChangeListener {
    JSlider slider;
    JPanel topPanel;
    JLabel label;
    simulationPanel panel;
    int sliderValue=1;
    public ui(){
        initializeComponents();
    }

    private void initializeComponents() {

        topPanel=new JPanel();
        topPanel.setBackground(Color.white);
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(1500,100));

        slider=new JSlider();
        slider.setMaximum(50);
        slider.setMinimum(0);
        slider.setBounds(600,20,400,50);
        slider.setBackground(Color.black);
        slider.setForeground(Color.magenta);
        //slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.addChangeListener(this);
        slider.setValue(1);


        topPanel.add(slider);
        panel=new simulationPanel(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        sliderValue=slider.getValue();
    }

}
