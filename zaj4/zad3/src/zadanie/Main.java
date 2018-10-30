package zadanie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
        public static void main(String[] argv){
            int szyfrowanie = 0;
            int algorytm = 0;
            //File in = new File("C:\\Users\\student\\Downloads\\maxheap\\zad3\\odczyt.txt");
            //do testu działania na systemie Windows
            File in = new File(argv[0]);
            Scanner odczyt = new Scanner(System.in);
            PrintWriter out = null;
            try {
                //out = new PrintWriter("C:\\Users\\student\\Downloads\\maxheap\\zad3\\zapis.txt");
                //do testu działania na systemie Windows
                out = new PrintWriter(argv[1]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("1. Szyfrowanie pliku.");
            System.out.println("2. Deszyfrowanie pliku.");
            String wybor = odczyt.nextLine();
            if (wybor.equals("1")) szyfrowanie = 1;
            else if (wybor.equals("2")) szyfrowanie = 2;

            System.out.println("1. Szyfr Rot11");
            System.out.println("2. Szyfr Polibiusza");
            wybor = odczyt.nextLine();
            if (wybor.equals("1")) algorytm = 1;
            else if (wybor.equals("2")) algorytm = 2;

            if (algorytm == 1) {
                if (szyfrowanie == 1) {
                    Cryptographer.cryptfile(in, out, new Rot11());
                } else if (szyfrowanie == 2) {
                    Cryptographer.decryptfile(in, out, new Rot11());
                }
            }
            if (algorytm == 2) {
                if (szyfrowanie == 1) {
                    Cryptographer.cryptfile(in, out, new Polibiusz());
                } else if (szyfrowanie == 2) {
                    Cryptographer.decryptfile(in, out, new Polibiusz());
                }
            }
        }
    }