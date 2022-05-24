package fractal;

import java.awt.*;

public class Parameters {

    public static final int a = 0,b = 0;
    
    public static final int m = 1; //maille (0 -> 3) 
    public static final int p = (int)Math.pow(m, 7-m); //pas 
    public static final int hauteur = 60; //(10 -> 60)
    public static final int d = 3; //deviation (inférieur ou égal au pas pour realisme)
    public static final int g = 1477; // graine (quelconque)
    public static final int l = 500; //(32 - 64 - 128)
    
    public static final int n = hauteur / 16;

    public static final int[][] h = new int[l+1][l+1];

    public static int[][] cF; //Grille apres calcul fractal

    public static int[] c; //Tableau nommé c

    public static final int choose = -2;

    public static final Graphics g2d  = null;

    public static final Color[] seaGradient = Do.makeGradient(new Color(0,0,128), new Color(0,255,255),15);
    public static final Color[] sandGradient = Do.makeGradient(new Color(202,205,0), new Color(255,237,0),5);
    public static final Color[] grassGradient = Do.makeGradient(new Color(106,234,0), new Color(58,129,0),15);
    public static final Color[] mountainGradient = Do.makeGradient(new Color(153,153,153), new Color(255,255,255),10);

    public static final Color[][] allGradients = {mountainGradient, grassGradient, sandGradient, seaGradient};

    public static final Color[] colorList = Do.mergeColorLists(allGradients);

    public static final int nbcolor = colorList.length;

    public static int randomSeed(){
        if (Parameters.g != 0)
            return Parameters.g;
        return (int)(Math.random()*Integer.MAX_VALUE);
    }
    
}
