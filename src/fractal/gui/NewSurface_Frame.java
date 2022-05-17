package fractal.gui;

import javax.swing.JFrame;

public class NewSurface_Frame extends JFrame {

    private NewSurface_Panel panel;

    public NewSurface_Frame(Menu menu) {
        panel = new NewSurface_Panel(menu);

        // Window parameters
        setTitle("New Surface");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(0, 0, 1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(panel);
    }

}
