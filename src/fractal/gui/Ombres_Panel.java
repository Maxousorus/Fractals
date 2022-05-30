package fractal.gui;

import java.util.Random;

import javax.swing.JPanel;
import java.awt.*;

import fractal.Do;
import fractal.Parameters;

public class Ombres_Panel extends JPanel{

    public int[][] getH() {
        return Parameters.h;
    }

    public Ombres_Panel() {;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        
        Random random = new Random(Parameters.g);

        Do.ombres((Graphics2D) g, Parameters.m, Parameters.hauteur, Parameters.d, Parameters.l, random, Parameters.h);
    }
    
}
