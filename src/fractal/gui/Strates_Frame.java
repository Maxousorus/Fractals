package fractal.gui;

import javax.swing.JFrame;

public class Strates_Frame extends JFrame{

    private Strates_Panel panel;

    public Strates_Frame(Menu menu) {
        panel = new Strates_Panel(menu);

        // Window parameters
        setTitle("Strates");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(0, 0, 1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(panel);
    }
    
}
