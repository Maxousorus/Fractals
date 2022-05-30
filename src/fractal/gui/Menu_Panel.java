package fractal.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Panel extends JPanel{

    private JButton newSurfaceButton;
    private JButton filDeFerButton;
    private JButton stratesButton;
    private JButton ombresButton;

    public Menu_Panel(Menu menu){

        newSurfaceButton = new JButton("New Surface");
        
        newSurfaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menu.openNewSurface();
                filDeFerButton.setEnabled(true);
            }
        });

        newSurfaceButton.setBounds(0, 150, 400, 150);

        add(newSurfaceButton);

        filDeFerButton = new JButton("Fil De Fer");
        filDeFerButton.setEnabled(false);
        
        filDeFerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menu.openFilDeFer();
                stratesButton.setEnabled(true);
            }
        });

        filDeFerButton.setBounds(0, 300, 400, 150);

        add(filDeFerButton);

        stratesButton = new JButton("Strates");
        stratesButton.setEnabled(false);

        stratesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menu.openStrates();
                ombresButton.setEnabled(true);
            }
        });

        stratesButton.setBounds(0, 450, 400, 150);

        add(stratesButton);

        ombresButton = new JButton("Ombres");
        ombresButton.setEnabled(false);

        ombresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menu.openOmbres();
            }
        });

        ombresButton.setBounds(0, 600, 400, 150);

        add(ombresButton);
    }
    
}
