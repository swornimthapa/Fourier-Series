import javax.swing.*;
import java.awt.*;

public class simulationWindow {
    JFrame frame;
   // simulationPanel panel;
    ui ui=new ui();
    public simulationWindow(){

        frame=new JFrame();
        frame.setTitle("Fourier Series");
       // frame.setLayout(null);


        frame.add(ui.topPanel,BorderLayout.NORTH);
        frame.add(ui.panel, BorderLayout.SOUTH);
        frame.pack();


        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
