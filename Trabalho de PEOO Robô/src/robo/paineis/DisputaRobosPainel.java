package robo.paineis;

import robo.MovimentoInvalidoException;
import robo.objetos.Alimento;
import robo.objetos.AtrRobo;
import robo.objetos.Robo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DisputaRobosPainel extends JPanel implements KeyListener {

    public static final int WIDTH = 500;
    public static final int HEIGTH = 500;

    private Robo roboA;
    private Robo roboB;
    private Alimento alimento;
    private String msgSisA;
    private String msgSisB;

    private void iniciate() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setFocusable(true);
        setVisible(true);
        requestFocus();
        addKeyListener(this);
    }

    public DisputaRobosPainel(Robo roboA, Robo roboB, Alimento alimento) {
        iniciate();
        this.roboA = roboA;
        this.roboB = roboB;
        this.alimento = alimento;
        this.msgSisA = "Para iniciar o programa aperte ENTER.";
        this.msgSisB = "Para iniciar o programa aperte ENTER.";
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0, WIDTH, HEIGTH);
        paintAtrRobo(g, roboA);
        paintAtrRobo(g, roboB);
        paintAtrRobo(g, alimento);
        g.setColor(Color.black);
        g.drawString(this.msgSisA, 210, 10);
        g.setColor(Color.MAGENTA);
        g.drawString(this.msgSisB, 210, 25);
    }

    public void paintAtrRobo(Graphics g, AtrRobo atrRobo) {
        g.setColor(atrRobo.getColor());
        g.fillRect(atrRobo.getX(), atrRobo.getY(), AtrRobo.SIZE, AtrRobo.SIZE);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int a = event.getKeyCode();

        System.out.println(a);

        if (a == KeyEvent.VK_ENTER) {

            AtomicBoolean flag = new AtomicBoolean(true);

            AtomicInteger countA = new AtomicInteger();
            AtomicInteger countB = new AtomicInteger();

            new Thread(() -> {
                while (flag.get()) {
                    try {
                        roboA.moverRandom();
                        countA.getAndIncrement();
                        this.msgSisA = roboA.toString();
                    } catch (MovimentoInvalidoException e) {
                        this.msgSisA = e.getMessage();
                    } if (roboA.achoAlimento(alimento)) {
                        flag.set(false);
                        this.msgSisA = this.roboA + " Robo Verde achou o Alimento.";
                        this.msgSisB = "Movimentos -> Robô Verde = " + countA + ", Robô Ciano = " + countB;
                        paint(this.getGraphics());
                        this.setEnabled(false);
                    } else {
                        paint(this.getGraphics());
                    }
                }
            }).start();

            new Thread(() -> {
                while (flag.get()) {
                    try {
                        roboB.moverRandom();
                        countB.getAndIncrement();
                        this.msgSisB = roboB.toString();
                    } catch (MovimentoInvalidoException e) {
                        this.msgSisB = e.getMessage();
                    } if (roboB.achoAlimento(alimento)) {
                        flag.set(false);
                        this.msgSisA = this.roboB + " Robo Ciano achou o Alimento.";
                        this.msgSisB = "Movimentos -> Robô Verde = " + countA + ", Robô Ciano = " + countB;
                        paint(this.getGraphics());
                        this.setEnabled(false);
                    } else {
                        paint(this.getGraphics());
                    }
                }
            }).start();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
