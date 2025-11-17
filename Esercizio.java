//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;
import java.util.Random;

class Esercizio {

    public static Scanner in = new Scanner( System.in );
    public static Random random = new Random();

    public static record Max(int massimo, int rIdx, int cIdx) { }

    public static Max calcolaMassimo(int[][] M, int nR, int nC) {
        int massimo = 0;
        int maxR = 0;
        int maxC = 0;

        for(int i = 0; i < nR; ++i){
            for(int j = 0; j < nC; ++j){
                if(M[i][j] > massimo){
                    massimo = M[i][j];
                    maxR = i;
                    maxC = j;
                }
            }
        }

        return new Max(massimo, maxR, maxC);

    }

    public static float calcolaMedia(int[][] M, int nR, int iC) {
        
        float somma = 0;
        
        for(int i = 0; i < nR; ++i){
            somma += M[i][iC];
        }

        float media = somma / nR;

        return media;
    }

    public static void riempiCasuale( int[][] M, int NR, int NC, int valMin, int valMax) {
        Random rand = new Random();
        for (int i=0; i <= NR-1; i=i+1 ) {
            for (int j=0; j <= NC-1; j=j+1) {
                M[i][j] = valMin + rand.nextInt((valMax+1)-valMin);
            }
        }
    }

    public static void main(String args[]) {
        int[][] M = new int[7][5];

        int NR = 7;
        int NC = 5;

        riempiCasuale(M, NR, NC, 280, 300);

        UtilsMatrice.visualizza(M);

        System.out.println();

        Max max = calcolaMassimo(M, NR, NC);

        System.out.println("Temperatura massima: " + max.massimo);
        System.out.println("Giorno: " + max.rIdx);
        System.out.println("Fascia oraria: " + max.cIdx);

        float[] Vm = new float[nC];

        for(int j = 0; j < nC; ++j){
            Vm[j] = calcolaMedia(M, nR, j);
        }

        System.out.println("Temperature medie per fasce orarie: ");
        
        for(int i = 0; i < Vm.length; ++i){
            System.out.println((i+1) + "° : " + Vm[i]);
        }

    }
}