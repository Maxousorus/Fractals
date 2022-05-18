package fractal;

import java.awt.*;
import java.util.Random;

public class Do {

    private static int[] move = new int[2];

    public static void plot(Graphics g, int x, int y, int c) {
        plot(g, x, y, getColor(c));
    }

    public static void plot(Graphics g, int x, int y, Color c) {
        g.setColor(c);
        g.drawRect(x, y, 1, 1);
    }


    public static Color getColor(int c){
        Color[] colorlist = Parameters.colorList;
        return colorlist[c % Parameters.nbcolor];
    }

    public static Color mixColors(Color color1, Color color2, double percent){
        double inverse_percent = 1.0 - percent;
        int redPart = (int) (color1.getRed()*percent + color2.getRed()*inverse_percent);
        int greenPart = (int) (color1.getGreen()*percent + color2.getGreen()*inverse_percent);
        int bluePart = (int) (color1.getBlue()*percent + color2.getBlue()*inverse_percent);
        return new Color(redPart, greenPart, bluePart);
    }

    public static Color[] makeGradient(Color color1, Color color2, int nbSteps){
        Color[] colorlist = new Color[nbSteps];
        for(int i = 0; i < nbSteps; i++){
            colorlist[i] = mixColors(color1, color2, (double)i/(double)nbSteps);
        }
        return colorlist;
    }

    public static Color[] mergeColorLists(Color[][] colorlist){
        int nbColors = 0;
        for(int i = 0; i < colorlist.length; i++){
            nbColors += colorlist[i].length;
        }
        Color[] mergedColorList = new Color[nbColors];
        int index = 0;
        for(int i = 0; i < colorlist.length; i++){
            for(int j = 0; j < colorlist[i].length; j++){
                mergedColorList[index] = colorlist[i][j];
                index++;
            }
        }
        return mergedColorList;
    }

    public static void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static int[][] surfaceDeBase(Graphics2D g, int maille, int hauteur, int taille, Random random) {
        if (maille < 0 || maille > 3) {
            throw new IllegalArgumentException("maille doit être compris entre 0 et 3");
        }

        int[][] surface = new int[taille + 1][taille + 1];
        int n = hauteur / Parameters.nbcolor;
        int pas = (int) Math.pow(2, 7 - maille);

        for (int x = 0; x <= taille; x += pas) {
            for (int y = 0; y <= taille; y += pas) {
                surface[x][y] = (int) (random.nextFloat() * hauteur);
                if (surface[x][y] < n) {
                    surface[x][y] = n;
                }

                int c = surface[x][y] / n;
                if (c > Parameters.nbcolor-1) {
                    c = Parameters.nbcolor-1;
                }

                Do.plot(g, x, y, c);
            }
        }

        return surface;
    }

    // Lignes 360 à 690
    public static int[][] calculFractal(Graphics2D g, int maille, int hauteur, int deviation, int taille, Random random,
            int[][] surface) {
        int n = hauteur / Parameters.nbcolor;
        int pas = (int) Math.pow(2, 7 - maille);

        while (pas > 1) {
            int q = pas / 2;
            int e = deviation / 2;

            // lignes 390 à 450
            for (int x = q; x <= taille - q; x += pas) {
                for (int y = q; y <= taille - q; y += pas) {
                    hauteur = (int) ((surface[x - q][y - q] + surface[x - q][y + q] + surface[x + q][y - q]
                            + surface[x + q][y + q]) / 4 + deviation * random.nextFloat() - e);
                    if (hauteur < n) {
                        hauteur = n;
                    }

                    int c = hauteur / n;
                    if (c > Parameters.nbcolor-1) {
                        c = Parameters.nbcolor-1;
                    }

                    surface[x][y] = hauteur;

                    Do.plot(g, x, y, c);
                }
            }

            // lignes 460 à 560
            for (int x = pas; x <= taille - pas; x += pas) {
                for (int y = q; y <= taille - q; y += pas) {
                    hauteur = (int) ((surface[x - q][y] + surface[x + q][y] + surface[x][y - q] + surface[x][y + q]) / 4
                            + deviation * random.nextFloat() - e);
                    if (hauteur < n) {
                        hauteur = n;
                    }

                    int c = hauteur / n;
                    if (c > Parameters.nbcolor-1) {
                        c = Parameters.nbcolor-1;
                    }

                    surface[x][y] = hauteur;

                    Do.plot(g, x, y, c);

                    hauteur = (int) ((surface[y - q][x] + surface[y + q][x] + surface[y][x - q] + surface[y][x + q]) / 4
                            + deviation * random.nextFloat() - e);
                    if (hauteur < n) {
                        hauteur = n;
                    }

                    c = hauteur / n;
                    if (c > Parameters.nbcolor-1) {
                        c = Parameters.nbcolor-1;
                    }

                    surface[y][x] = hauteur;

                    Do.plot(g, y, x, c);
                }
            }

            // lignes 570 à 660
            for (int i = q; i <= taille - q; i += pas) {
                hauteur = (int) ((surface[0][i - q] + surface[0][i + q] + surface[q][i]) / 3
                        + deviation * random.nextFloat() - e);
                if (hauteur < n) {
                    hauteur = n;
                }
                surface[0][i] = hauteur;

                hauteur = (int) ((surface[taille][i - q] + surface[taille][i + q] + surface[taille - q][i]) / 3
                        + deviation * random.nextFloat() - e);
                if (hauteur < n) {
                    hauteur = n;
                }
                surface[taille][i] = hauteur;

                hauteur = (int) ((surface[i - q][0] + surface[i + q][0] + surface[i][q]) / 3
                        + deviation * random.nextFloat() - e);
                if (hauteur < n) {
                    hauteur = n;
                }
                surface[i][0] = hauteur;

                hauteur = (int) ((surface[i - q][taille] + surface[i + q][taille] + surface[i][taille - q]) / 3
                        + deviation * random.nextFloat() - e);
                if (hauteur < n) {
                    hauteur = n;
                }
                surface[i][taille] = hauteur;
            }

            pas /= 2;
            deviation /= 2;
        }

        return surface;
    }

    public static void move(int x , int y){
        move[0] = x;
        move[1] = y;
    }

    public static void draw(Graphics g, int x , int y, int c){
        draw(g, x, y, getColor(c));
    }

    public static void draw(Graphics g, int x, int y, Color c){
        g.setColor(c);
        g.drawLine(move[0], move[1], x, y);
    }

    public static int max(int a,int b){
        if(a>b){
            return a;
        }
        return b;
    }

    public static int[][] filDeFer(Graphics2D g, int maille, int hauteur, int deviation, int taille, Random random, int[][] surface) {
        int o = 160;
        int k = 0;
        Color filDeFerColor = Color.BLUE;
        move(0, 40);
        draw(g, 320, 0, filDeFerColor);
        draw(g, 640, 40, filDeFerColor);
        int[] c = new int[320];
        int h = hauteur;
        int fh = 0;
        for(int y = 0; y < taille;y = y+2){ //ligne 890
            move(o*4-320, c[o+k]);
            k=0;
            o = 160 - y;
            if(o < 0){
                k = -o;
            }
            int x;
            for(x = k; x < 128; x = x + 2){
                taille = surface[x][y] + x + y;
                h = max(c[x+o], taille);
                c[x+o] = h;
                draw(g, (o+x)*4-320, h, filDeFerColor);
            }
            draw(g, (o+x)*4-322, fh, filDeFerColor);
            fh = h;
        }
        Parameters.c = c;
        return surface;
    }

    public static int[][] strates(Graphics2D g, int maille, int hauteur, int deviation, int taille, Random random, int[][] surface) {
        int n = hauteur / Parameters.nbcolor;
        int nm = n*4;
        int[][] h = Parameters.cF;
        int[] c = Parameters.c;
        for(int i = 0; i < 80; i++){
            hauteur = h[0][i] + i;
            if(hauteur < nm+i)
                hauteur = nm+i;
            c[80-i] = hauteur-2;
            hauteur = h[i][0] + i;
            if(hauteur < nm+i)
                hauteur = nm+i;
            c[80+i] = hauteur-2;
        }

        int nmx;
        int a = 0;
        int couleur = 0;

        for(int x = 0; x < taille+1; x++){
            for(int y = 0; y < taille; y++){
                nmx = nm + x + y;
                a = 80 - y + x;
                if(a < 0 || a > 319){
                    continue;
                }
                
                hauteur = h[x][y] + x + y;
                couleur = h[x][y];
                if(couleur > Parameters.nbcolor-1){
                    couleur = Parameters.nbcolor-1;
                }
                if(hauteur < nmx){
                    hauteur = nmx;
                }
                if(hauteur <= c[a]){
                    //plot(g, a*4, c[a], 0);
                }
                if(hauteur > c[a]){
                    move(a*4, c[a]+2);
                    //ici
                    draw(g, a*4, hauteur, couleur); // peut etre à mettre dans le IF ci dessus
                }
                c[a] = hauteur;
            }
        }
        c = Parameters.c;
        return surface;
    }

    public static int[][] ombres(Graphics2D g, int maille, int hauteur, int deviation, int taille, Random random, int[][] surface) { 
        
        int[] c = Parameters.c; 
        int a;

        for(int i = 0; i < 80; i++){
            c[80-i] = surface[0][i] + i - 2;
            c[80+i] = surface[i][0] + i - 2;
        }
        int o1;
        int o2;
        Color couleur;

        for(int y = 0; y < taille; y++){
            o1 = 0;
            o2 = 0;
            for(int x = taille; x > 0; x--){
                a = 80 - y + x;
                if(a < 0 || a > 319){
                    continue;
                }
                hauteur = surface[x][y] + x + y;
                
                couleur = new Color(32,32,32);

                if(surface[x][y] >= o1)
                    o1 = surface[x][y] + 1;
                else
                    couleur = new Color(66,66,66);
                
                if(surface[x][y] >= o2)
                    o2 = surface[x][y] + 2;
                else
                    couleur = new Color(99,99,99);

                if(hauteur < c[a]){
                    plot(g, a*4, c[a]-2, Color.gray);
                    //GOTO 1290 mais ????
                }

                move(a*4,c[a]);
                draw(g, a*4, hauteur, couleur);
                c[a] = hauteur + 2;
                o1 -= 1;
                o2 -= 2;
            }
        }

        return surface;
    }
}
