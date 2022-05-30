package fractal.gui;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

import fractal.Do;
import fractal.Parameters;

public class NewSurface_Panel extends JPanel {

    public int[][] getH() {
        return Parameters.h;
    }

    public NewSurface_Panel() {;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        
        Random random = new Random(Parameters.g);

        int[][] h = Do.surfaceDeBase((Graphics2D) g, Parameters.m, Parameters.hauteur, Parameters.l, random);
        h = Do.calculFractal((Graphics2D) g, Parameters.m, Parameters.hauteur, Parameters.d, Parameters.l, random, h);
        Parameters.h = h;
    }
    
}
