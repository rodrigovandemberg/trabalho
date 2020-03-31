package robo;

import robo.objetos.AtrRobo;

public class MovimentoInvalidoException extends Exception {

    private int x, y;

    private AtrRobo atrRobo;

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

    public AtrRobo getAtrRobo() {
        return atrRobo;
    }

    public void setAtrRobo(AtrRobo atrRobo) {
        this.atrRobo = atrRobo;
    }

    public MovimentoInvalidoException(int x, int y, AtrRobo atrRobo) {
        this.x = x;
        this.y = y;
        this.atrRobo = atrRobo;
    }

    @Override
    public String getMessage() {
        return "Não é possível mover " + atrRobo + " para (" + x + ", " + y + ")";
    }
}
