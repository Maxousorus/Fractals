package fractal;

import java.awt.*;

public class Parameters {

    public static final int a = 0,b = 0,c = 0;
    
    public static final int m = 1; //maille (0 -> 3) 
    public static final int p = (int)Math.pow(m, 7-m); //pas 
    public static final int hauteur = 60; //(>=60)
    public static final int d = 3; //deviation (inférieur ou égal au pas pour realisme)
    public static final int l = 1920; //(recommandation : <3000)

    public static int g = 12354; // graine (0 = aléatoire)
    
    public static final int n = hauteur / 16;

    public static final int[][] h = new int[l+1][l+1];

    public static final int choose = -2;

    public static final Graphics g2d  = null;

    public static final Color[] seaGradient = Do.makeGradient(new Color(0,255,255),new Color(0,0,128), 20);
    public static final Color[] sandGradient = Do.makeGradient(new Color(202,205,0),new Color(255,237,0), 5);
    public static final Color[] grassGradient = Do.makeGradient(new Color(58,129,0),new Color(106,234,0), 15);
    public static final Color[] mountainGradient = Do.makeGradient(new Color(255,255,255),new Color(153,153,153), 10);

    public static final Color[][] allGradients = {{Color.WHITE}, seaGradient, sandGradient, grassGradient, mountainGradient};

    public static final Color[] colorList = Do.mergeColorLists(allGradients);

    public static final int nbcolor = colorList.length;

    public static int randomSeed(){
        if (Parameters.g != 0)
            return Parameters.g;
        return (int)(Math.random()*Integer.MAX_VALUE);
    }
    
}
