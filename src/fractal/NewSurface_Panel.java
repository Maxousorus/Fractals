package fractal;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class NewSurface_Panel extends JPanel {

    private int l = Parameters.l; //(32 - 64 - 128)

    private int[][] h = new int[l+1][l+1];

    public int[][] getH() {
        return h;
    }

    public NewSurface_Panel(Menu menu) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        
        Parameters.g = Parameters.randomSeed();
        System.out.println(Parameters.g);
        Random random = new Random(Parameters.g);

        h = Do.surfaceDeBase((Graphics2D) g, Parameters.m, Parameters.hauteur, Parameters.l, random);
        h = Do.calculFractal((Graphics2D) g, Parameters.m, Parameters.hauteur, Parameters.d, Parameters.l, random, h);
    }
    
}
