package wielomians;

import sun.java2d.loops.DrawRect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MyPanel extends JPanel implements ActionListener{
    int ia3, ia2, ia1, ia0, izakresA, izakresB,iprobe;


    JButton button;
    JTextField jTextField1;
    JTextField a3, a2, a1, a0, zakresA, zakresB, probe;
    JLabel La3, La2, La1, La0, LzakresA, LzakresB, Lprobe;
    public MyPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(500, 400));
        a3 = new JTextField("");
        a3.setBounds(300, 0, 150, 20);
        add(a3);
        La3 = new JLabel("Podaj współczynnik przy x^3:");
        La3.setBounds(0, 0, 200, 20);
        add(La3);

        a2 = new JTextField("");
        a2.setBounds(300, 30, 150, 20);
        add(a2);
        La2 = new JLabel("Podaj współczynnik przy x^2:");
        La2.setBounds(0, 30, 200, 20);
        add(La2);

        a1 = new JTextField("");
        a1.setBounds(300, 60, 150, 20);
        add(a1);
        La1 = new JLabel("Podaj współczynnik przy x:");
        La1.setBounds(0, 60, 200, 20);
        add(La1);

        a0 = new JTextField("");
        a0.setBounds(300, 90, 150, 20);
        add(a0);
        La0 = new JLabel("Podaj współczynnik wolny:");
        La0.setBounds(0, 90, 200, 20);
        add(La0);

        zakresA = new JTextField("");
        zakresA.setBounds(300, 120, 150, 20);
        add(zakresA);
        LzakresA = new JLabel("Podaj początek zakresu:");
        LzakresA.setBounds(0, 120, 200, 20);
        add(LzakresA);

        zakresB = new JTextField("");
        zakresB.setBounds(300, 150, 150, 20);
        add(zakresB);
        LzakresB = new JLabel("Podaj koniec zakresu:");
        LzakresB.setBounds(0, 150, 200, 20);
        add(LzakresB);

        probe = new JTextField("");
        probe.setBounds(300, 180, 150, 20);
        add(probe);
        Lprobe = new JLabel("Podaj próbkowanie na wykres:");
        Lprobe.setBounds(0, 180, 200, 20);
        add(Lprobe);
        button = new JButton("Generuj");
        button.setBounds(300,210,100,20);
        add(button);
        button.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e){
        JFrame frame = new JFrame("Wielomiany");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            this.ia3 = Integer.parseInt(a3.getText());
            this.ia2 = Integer.parseInt(a2.getText());
            this.ia1 = Integer.parseInt(a1.getText());
            this.ia0 = Integer.parseInt(a0.getText());
            this.izakresA = Integer.parseInt(zakresA.getText());
            this.izakresB = Integer.parseInt(zakresB.getText());
            this.iprobe = Integer.parseInt(probe.getText());
        } catch (NumberFormatException nfe) {

        }
        frame.add(new NewPanel(ia3, ia2, ia1, ia0, izakresA, izakresB,iprobe));
        frame.pack();
        frame.setVisible(true);

    }
}

