import javax.swing.*;

public class simulationWindow {
    JFrame frame;
    simulationPanel panel;
    public simulationWindow(){

        frame=new JFrame();
        frame.setTitle("Fourier Series");
        frame.setSize(900,700);

        panel=new simulationPanel();
        frame.add(panel);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
