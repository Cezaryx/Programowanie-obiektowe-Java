package tescik;

import tescik.prostokat;

import java.util.*;
import java.util.LinkedList;

public class Test{
    private LinkedList<prostokat> figury;
    public static void main(String [] args){
        int x=0;
        int max=0;
        LinkedList<prostokat> figury = new LinkedList<>();
        Scanner odczyt = new Scanner(System.in);
        while(x!=1){
            System.out.println("Menu:");
            System.out.println("1-Wczytaj prostokat");
            System.out.println("2-Wyswietl wszystkie prosokaty");
            System.out.println("3-Oblicz sume pol wszystkich prostokatow");
            System.out.println("4-Zakoncz");
            int i=odczyt.nextInt();
            switch(i){
                case 1: System.out.println("Podaj dlugosc");
                        double a=odczyt.nextInt();
                        System.out.println("Podaj szerokosc");
                        double b=odczyt.nextInt();
                        figury.add(new prostokat(a,b));
                        max+=1;
                        break;
                case 2: for(int j=0;j<max;j++){
                            figury.get(j).pokaz_wymiary();
                        };
                        break;
                case 3: int all=0;
                        for(int j=0;j<max;j++){
                            all+=figury.get(j).pokaz_pole();
                        };
                        System.out.println("Laczne pole prostokatow to: " + all);
                        break;
                case 4: x=1;
                        break;
                default: System.out.println("Niepoprawny wybór");
                        break;


            }
        }
    }

}

