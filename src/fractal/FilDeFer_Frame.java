package fractal;

import javax.swing.JFrame;

public class FilDeFer_Frame extends JFrame {
    
    private FilDeFer_Panel panel;

    public FilDeFer_Frame(Menu menu) {
        panel = new FilDeFer_Panel(menu);

        // Window parameters
        setTitle("Fil De Fer");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(0, 0, 1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(panel);
    }

}
