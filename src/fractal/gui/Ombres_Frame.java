package fractal.gui;

import javax.swing.JFrame;

public class Ombres_Frame extends JFrame{

    private Ombres_Panel panel;

    public Ombres_Frame(Menu menu){
        panel = new Ombres_Panel(menu);

        //Window parameters
        setTitle("Ombres");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(0, 0, 1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(panel);
    }
    
}
