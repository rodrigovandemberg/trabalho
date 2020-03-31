package robo.objetos;


import robo.MovimentoInvalidoException;
import robo.paineis.Painel;
import java.awt.*;
import java.util.Random;


public class Robo extends AtrRobo {


    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String RIGHT = "right";
    public static final String LEFT = "left";


    public Robo(Color cor) {
        super(0, 0, cor);
    }

    public void mover(String direcao) throws IllegalArgumentException, MovimentoInvalidoException {
        if (direcao.equals(UP)) {
            up();
        } else if (direcao.equals(DOWN)) {
            down();
        } else if (direcao.equals(RIGHT)) {
            right();
        } else if (direcao.equals(LEFT)) {
            left();
        } else {
            throw new IllegalArgumentException("Não é possível ir para essa direção: " + direcao);
        }
    }

    public void mover(int direcao) throws IllegalArgumentException, MovimentoInvalidoException {
        if (direcao == 1) {
            up();
        } else if (direcao == 2) {
            down();
        } else if (direcao == 3) {
            right();
        } else if (direcao == 4) {
            left();
        } else {
            throw new IllegalArgumentException("Não é possível ir para essa direção: " + direcao);
        }
    }

    public void moverRandom() throws MovimentoInvalidoException {
        Random random = new Random();
        mover(random.nextInt(4) + 1);
    }

    private void up() throws MovimentoInvalidoException {
        int y = this.y - SIZE;
        if (posicaoValida(this.x, y)) {
            setY(y);
        } else throw new MovimentoInvalidoException(this.x, y, this);
    }

    private void down() throws MovimentoInvalidoException {
        int y = this.y + SIZE;
        if (posicaoValida(this.x, y)) {
            setY(y);
        } else throw new MovimentoInvalidoException(this.x, y, this);
    }

    private void right() throws MovimentoInvalidoException {
        int x = this.x + SIZE;
        if (posicaoValida(x, this.y)) {
            setX(x);
        } else throw new MovimentoInvalidoException(x, this.y, this);
    }

    private void left() throws MovimentoInvalidoException {
        int x = this.x - SIZE;
        if (posicaoValida(x, this.y)) {
            setX(x);
        } else throw new MovimentoInvalidoException(x, this.y, this);
    }

    public static boolean posicaoValida(int x, int y) {
        if (x < 0 || x > Painel.WIDTH - SIZE || y < 0 || y > Painel.HEIGTH - SIZE)
            return false;
        else
            return true;
    }

    public boolean achoAlimento(Alimento alimento) {
        return this.x == alimento.getX() && this.y == alimento.getY();
    }

    @Override
    public String toString() {
        return "Robo (" + + x + "," + y + ')';
    }

}
