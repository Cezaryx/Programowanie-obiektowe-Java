package rysowanie;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.util.ArrayList;
import java.util.List;


public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    int mouseX, mX;
    int mouseY, mY;
    boolean moving=false;
    boolean clicked=false;
    int cX, cY;
    Shape moved;
    public MyPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);

    }
    Shape [] shapes;
    public void setShapes(Shape [] shape){
        shapes=shape;
    }
    public void paintComponents(Graphics g){

        for (Shape shape : shapes) {
            if(clicked){
                moving=shape.zawiera(cX,cY);
            }
            if(moving){
                if(moved==null){
                    moved=shape;
                }
                moved.setX(moved.getX()-mouseX);
                moved.setY(moved.getY()-mouseY);

            }

            shape.draw(g);
        }
        mouseX=0; mouseY=0;

    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,1000,1000);
        this.paintComponents(g);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked=true;
        mX=e.getX();
        mY=e.getY();
        cX=e.getX();
        cY=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        moving = false;
        moved=null;
        clicked=false;
        cX=0;
        cY=0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX=mX-e.getX();
        mouseY=mY-e.getY();
        mX=e.getX();
        mY=e.getY();
        cX=e.getX();
        cY=e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }


}


