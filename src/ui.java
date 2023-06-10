import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ui implements ChangeListener, ActionListener {
    JSlider slider;
    JPanel topPanel;
    JLabel selectWave;
    JLabel selectEpicycles;
    JComboBox waves;
    simulationPanel panel;
    int sliderValue=1;
    String waveName="square wave";
    public ui(){
        initializeComponents();
    }

    private void initializeComponents() {

        topPanel=new JPanel();
        topPanel.setBackground(Color.black);
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(1500,100));

        slider=new JSlider();
        slider.setMaximum(50);
        slider.setMinimum(0);
        slider.setBounds(950,20,400,50);
        slider.setBackground(Color.black);
        slider.setForeground(Color.white);
        //slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.addChangeListener(this);
        slider.setValue(1);

        String[] waveNames={"square wave","sawtooth wave"};
        waves=new JComboBox(waveNames);
        waves.setBounds(250,28,400,30);
        waves.setFont(new Font("Apple Casual",Font.PLAIN,15));
        waves.addActionListener(this);
        waves.setForeground(Color.black);
      // = waves.setBackground(Color.BLACK);

        selectWave=new JLabel("Approximation To:");
        selectWave.setBounds(90,17,200,50);
        selectWave.setFont(new Font("Apple Casual",Font.PLAIN,15));
        selectWave.setForeground(Color.white);

        selectEpicycles=new JLabel("Number Of Epicycles:");
        selectEpicycles.setBounds(750,17,200,50);
        selectEpicycles.setFont(new Font("Apple Casual",Font.PLAIN,15));
        selectEpicycles.setForeground(Color.white);

        topPanel.add(selectEpicycles);
        topPanel.add(waves);
        topPanel.add(selectWave);
        topPanel.add(slider);
        panel=new simulationPanel(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        sliderValue=slider.getValue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==waves){
            waveName= (String) waves.getSelectedItem();
        }
    }
}
