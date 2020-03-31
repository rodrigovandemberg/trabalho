package robo;

import robo.objetos.RoboInteligente;
import robo.objetos.AtrRobo;
import robo.paineis.DisputaRobosPainel2;
import robo.objetos.Robo;
import robo.objetos.Alimento;
import robo.paineis.Painel;
import javax.swing.*;
import java.awt.*;

import static robo.Main.pegarCoordenada;

public class Main3 {

    public static void main(String[] args) {
        Robo verde = new Robo(Color.GREEN);
        Robo ciano = new RoboInteligente(Color.CYAN);

        int x, y;

        System.out.println("###################################");
        System.out.println("###################################");
        System.out.println("#######  Bem vindo ao Robô  #######");
        System.out.println("###################################");
        System.out.println("###################################");
        System.out.println();

        x = pegarCoordenada("Digite a Posição do Alimento no Eixo X entre 0 e 4:");
        y = pegarCoordenada("Digite a Posição do Alimento no Eixo Y entre 0 e 4:");

        Alimento alimento = new Alimento(x * AtrRobo.SIZE, y * AtrRobo.SIZE);

        JFrame frame = new JFrame("DISPUTA DOS ROBÔS");
        frame.setContentPane(new DisputaRobosPainel2(verde, ciano, alimento));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setPreferredSize(new Dimension(Painel.WIDTH + 10, Painel.WIDTH + 10));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
