package robo.objetos;

import java.awt.*;


public abstract class AtrRobo {


    public static final int SIZE = 100;

    protected int x, y;
    protected Color cor;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return cor;
    }

    public void setColor(Color cor) {
        this.cor = cor;
    }

    public AtrRobo(int x, int y, Color cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

}
