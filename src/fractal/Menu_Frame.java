package fractal;

import javax.swing.JFrame;

public class Menu_Frame extends JFrame{

    private Menu_Panel panel;

    public Menu_Frame(Menu menu){
        panel = new Menu_Panel(menu);

        //Window parameters
        setTitle("Menu Fractal");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(panel);
    }
    
}
