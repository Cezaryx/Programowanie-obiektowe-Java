package tescik;

import java.io.*;

public class prostokat{
    protected double a;
    protected double b;
    public double pokaz_pole(){
        return a*b;
    }
    public prostokat(double dl, double szer){
        a=dl;
        b=szer;
    }
    public void pokaz_wymiary(){
        System.out.println("dlugosc: " + a);
        System.out.println("Szerokosc: " + b);
    }
}