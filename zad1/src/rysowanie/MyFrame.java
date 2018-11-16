package rysowanie;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame {

    public static void main(String[] args) {
        try {
            MyFrame frame = new MyFrame();
            MyPanel panel = new MyPanel();
            Kolo a1 = new Kolo();
            Kwadrat a2 = new Kwadrat();
            Trojkat a3 = new Trojkat();
            a1.setX(0);
            a1.setY(0);
            a2.setX(300);
            a2.setY(0);
            a3.setX(600);
            a3.setY(0);
            Shape[] sh = new Shape[]{a1, a2, a3};

            panel.setShapes(sh);
            frame.getContentPane().add(panel);
            frame.setSize(1000, 1000);
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });
        } catch (UnsupportedOperationException e) {
            System.out.println("błąd ");
        }

    }
}