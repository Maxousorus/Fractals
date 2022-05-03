package fractal;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class Menu_Panel extends JPanel{

    private JButton newSurfaceButton;

    public Menu_Panel(Menu menu){

        newSurfaceButton = new JButton("New Surface");
        
        newSurfaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menu.openNewSurface();
            }
        });

        newSurfaceButton.setBounds(0, 150, 400, 150);

        add(newSurfaceButton, BorderLayout.NORTH);
    }
    
}