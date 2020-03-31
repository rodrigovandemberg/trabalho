package robo.objetos;

import robo.MovimentoInvalidoException;
import java.awt.*;

public class RoboInteligente extends Robo{

    public RoboInteligente(Color cor) {
        super(cor);
    }

    @Override
    public void mover(String direction) throws MovimentoInvalidoException {
        try {
            super.mover(direction);
        } catch (MovimentoInvalidoException e) {
            moverRandom();
        }
    }

    @Override
    public String toString() {
        return "Robo Inteligente (" + + x + "," + y + ')';
    }
}
