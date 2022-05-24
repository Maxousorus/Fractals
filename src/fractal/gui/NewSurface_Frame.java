package fractal.gui;

import java.lang.reflect.Parameter;

import javax.swing.JFrame;

import fractal.Parameters;

public class NewSurface_Frame extends JFrame {

    private NewSurface_Panel panel;

    public NewSurface_Frame() {
        panel = new NewSurface_Panel();

        // Window parameters
        setTitle("New Surface");
        setBounds(0, 0, Parameters.l+16, Parameters.l+38);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(panel);
    }

}
