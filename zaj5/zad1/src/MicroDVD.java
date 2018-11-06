import wyj.ExceptionDVD;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class MicroDVD {
    private static String delay (String in, int delay, int framerate) throws ExceptionDVD{
        //Stworzenie wyrażenia regularnego do sprawdzenia poprawności linii z pliku źródłowego
        Pattern goodpattern = Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.+)");
        Matcher m = goodpattern.matcher(in);
        StringBuilder wynik = new StringBuilder();

        if(m.find()) {
            int newStart = Integer.parseInt(m.group(1)) + (delay * framerate) / 1000;
            int newEnd = Integer.parseInt(m.group(2)) + (delay * framerate) / 1000;
            wynik.append("{").append(newStart).append("}{").append(newEnd).append("}").append(m.group(3));

            return wynik.toString();
            //zwrócenie wyjątku w wypadku błędu w wyrażeniu
        } else throw new ExceptionDVD(in);
    }


    public static void main(String[] argv) {
        String pathIn;
        String pathOut;
        int delay_ms;
        int framerate;
        try {
            /*pathIn = "C:\\Users\\student\\Downloads\\maxheap\\zad1\\gravity.txt";
            pathOut = "C:\\Users\\student\\Downloads\\maxheap\\zad1\\gravity2.txt";
            delay_ms=50;
            framerate = 30;
            Do testów na Windowsie(ścieżki mogą się różnić)*/
            pathIn = argv [0];
            pathOut = argv [1];
            delay_ms = Integer.parseInt(argv[2]);
            framerate = Integer.parseInt(argv[3]);
        //poniżej: obsługa wyjątków
        //błąd braku ścieżki
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Invalid or missing starting values");
            return;
        }
        //błąd złej wartości framerat'u
        if (framerate<0){
            System.err.println("Framerate can't be less or equal zero");
        }
        File in = new File(pathIn);
        PrintWriter OutputFile = null;
        try {
            OutputFile = new PrintWriter(pathOut);
        //błąd wczytywania pliku
        } catch (FileNotFoundException e) {
            System.err.println("Invalid Path of PathIn: " + pathOut);
            return;
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(in);
        //błąd zapisania pliku
        } catch (FileNotFoundException e) {
            System.err.println("Invalid Path of PathOut: " + pathIn);
            return;
        }
        while (scanner.hasNextLine()) {
            try {
                OutputFile.println(MicroDVD.delay(scanner.nextLine(), delay_ms, framerate));
            }
            catch (ExceptionDVD e){
                System.err.println(e.getMessage());
                return;
            }
        }



        OutputFile.close();

    }



}
