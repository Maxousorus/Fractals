package fractal.gui;

import java.awt.*;
import java.util.Random;

import javax.swing.JPanel;

import fractal.Do;
import fractal.Parameters;

public class FilDeFer_Panel extends JPanel{

    public int[][] getH() {
        return Parameters.h;
    }

    public FilDeFer_Panel() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        
        Random random = new Random(Parameters.g);

        Do.filDeFer((Graphics2D) g, Parameters.m, Parameters.hauteur, Parameters.d, Parameters.l, random, Parameters.h);
        
    }
    
}
