package fractal;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class Menu_Panel extends JPanel{

    private JButton newSurfaceButton;
    private JButton filDeFerButton;
    private JButton stratesButton;

    public Menu_Panel(Menu menu){

        newSurfaceButton = new JButton("New Surface");
        
        newSurfaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menu.openNewSurface();
            }
        });

        newSurfaceButton.setBounds(0, 150, 400, 150);

        add(newSurfaceButton);

        filDeFerButton = new JButton("Fil De Fer");
        
        filDeFerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menu.openFilDeFer();
            }
        });

        filDeFerButton.setBounds(0, 300, 400, 150);

        add(filDeFerButton);

        stratesButton = new JButton("Strates");

        stratesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menu.openStrates();
            }
        });

        stratesButton.setBounds(0, 450, 400, 150);

        add(stratesButton);

        
    }
    
}
