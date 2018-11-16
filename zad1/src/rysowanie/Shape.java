package rysowanie;

import java.awt.*;

public abstract class Shape{
    public String name;
    public int X,Y;
    public abstract void draw(Graphics arg0);

    public abstract int getX();
    public abstract int getY();

    public abstract void setX(int x);
    public abstract void setY(int y);

    public abstract boolean zawiera(int x, int y);
}
