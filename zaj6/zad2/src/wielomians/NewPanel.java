package wielomians;

import javax.swing.*;
import java.awt.*;
import static java.lang.Math.*;

public class NewPanel extends JPanel {
    int a,b,c,d,z1,z2,p;
    public NewPanel(int ia3,int ia2,int ia1,int ia0,int izakresA,int izakresB,int iprobe){
        setPreferredSize(new Dimension(500, 500));
        a=ia3;
        b=ia2;
        c=ia1;
        d=ia0;
        z1=izakresA;
        z2=izakresB;
        p=iprobe;
    }
    //błędne działanie, rysunki są nie wyskalowane względem osi y
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawLine(0, 250, 500, 250);
        g.drawLine(250, 0, 250, 500);
        int[] y= new int [p];
        int[] x= new int [p];
        System.out.println(d);
        for (int i = 0; i < p; i++) {
            x [i] = z1 +i*abs(z2-z1/p);
            y [i] = (a*x [i]*x [i]*x [i]+ b*x [i]*x [i] + c*x [i] +d);
        }
        g.setColor(Color.black);
        for(int i = 0; i < p-1; i=i+500/p){
            g.drawLine(i,250-y[i],i+1,250-y[i+1]);
        }
    }
}
