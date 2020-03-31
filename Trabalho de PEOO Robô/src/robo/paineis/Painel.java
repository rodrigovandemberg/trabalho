package robo.paineis;

import robo.objetos.Alimento;
import robo.objetos.AtrRobo;
import robo.objetos.Robo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Painel extends JPanel implements KeyListener {

    public static final int WIDTH = 500;
    public static final int HEIGTH = 500;

    private Robo robo;
    private Alimento alimento;
    private String msgSis;


    @Override
    public void keyPressed(KeyEvent event) {
        int a = event.getKeyCode();
        try {
            if (a == KeyEvent.VK_UP) this.robo.mover(Robo.UP);
            else if (a == KeyEvent.VK_DOWN) this.robo.mover(Robo.DOWN);
            else if (a == KeyEvent.VK_RIGHT) this.robo.mover(Robo.RIGHT);
            else if (a == KeyEvent.VK_LEFT) this.robo.mover(Robo.LEFT);
            this.msgSis = robo.toString();
        } catch (Exception e) {
            this.msgSis = e.getMessage();
        } finally {
            if (robo.achoAlimento(alimento)) {
                this.msgSis = this.robo + " Achou o Alimento.";
                paint(this.getGraphics());
                this.setEnabled(false);
            } else {
                paint(this.getGraphics());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    private void iniciate() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setFocusable(true);
        setVisible(true);
        requestFocus();
        addKeyListener(this);

    }

    public Painel(Robo robo, Alimento alimento) {
        iniciate();
        this.robo = robo;
        this.alimento = alimento;
        this.msgSis = "";
    }

    public void paintAtrRobo(Graphics g, AtrRobo atrRobo) {
        g.setColor(atrRobo.getColor());
        g.fillRect(atrRobo.getX(), atrRobo.getY(), AtrRobo.SIZE, AtrRobo.SIZE);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0, WIDTH, HEIGTH);
        paintAtrRobo(g, robo);
        paintAtrRobo(g, alimento);
        g.setColor(Color.MAGENTA);
        g.drawString(this.msgSis, 205, 10);
    }
}
