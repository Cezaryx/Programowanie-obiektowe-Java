package rysowanie;
import java.awt.*;
import java.awt.geom.*;


public class Kwadrat extends Shape {
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
        Graphics g = arg0;
        g.drawRect(X, Y, 200, 200);
        g.fillRect(X,Y,200,200);
    }
    public boolean zawiera(int x, int y){
        return(x>X && x<X+200 && y>Y && y<Y+200);
    }
}
