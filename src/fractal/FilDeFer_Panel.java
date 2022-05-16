package fractal;

import java.awt.*;
import java.util.Random;

import javax.swing.JPanel;

public class FilDeFer_Panel extends JPanel{

    private int a = Parameters.a,
                b = Parameters.b,
                c = Parameters.c;
    
    private int m = Parameters.m; //maille (0 -> 3) 
    private int p = (int)Math.pow(m, 7-m); //pas 
    private int hauteur = Parameters.hauteur; //(10 -> 60)
    private int d = Parameters.d; //deviation (inférieur ou égal au pas pour realisme)
    private int g = Parameters.g; // graine (quelconque)
    private int l = Parameters.l; //(32 - 64 - 128)
    
    private int n = hauteur / 16;

    private int[][] h = new int[l+1][l+1];

    private int temph;

    private Random r = new Random(g);

    private int nbcolor = Parameters.nbcolor;

    public int[][] getH() {
        return h;
    }

    public FilDeFer_Panel(Menu menu) {;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        
        Random random = new Random(Parameters.g);

        Do.filDeFer((Graphics2D) g, Parameters.m, Parameters.hauteur, Parameters.d, Parameters.l, random, Parameters.cF);
        
    }
    
}
