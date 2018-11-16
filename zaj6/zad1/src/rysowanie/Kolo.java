package rysowanie;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Kolo extends Shape{
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }

    public void setX(int x){
        this.X=x;
    }
    public void setY(int y){
        this.Y=y;
    }
    public void draw(Graphics arg0){
        arg0.setColor(Color.red);
        arg0.fillOval(X, Y, 200, 200);
    }
    public boolean zawiera(int x, int y) {
        return ((x-(X+100))*(x-(X+100))+((y-(Y+100)))*((y-(Y+100)))<=100*100);
    }
}

