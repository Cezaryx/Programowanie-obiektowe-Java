package rysowanie;

import java.awt.*;

public class Trojkat extends Shape{
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
        int xpoints[] = {X,X+100,X+200};
        int ypoints[] = {Y+200,Y,Y+200};
        int npoints = 3;
        g.fillPolygon(xpoints, ypoints, npoints);
    }
    public boolean zawiera(int x, int y) {
        int xpoints[] = {X,X+100,X+200};
        int ypoints[] = {Y+200,Y,Y+200};
        return (((y+Y+200)*100-(-200)*(x-X)>0) && (((y-Y)*100 - (200)*(x-X+100))<0) && (((y-Y-200)*(-200)-(-200)*(x-X-200))<0));

    }
}
