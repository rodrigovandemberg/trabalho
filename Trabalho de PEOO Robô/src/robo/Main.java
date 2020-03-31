package robo;

import robo.objetos.AtrRobo;
import robo.objetos.Robo;
import robo.objetos.Alimento;
import robo.paineis.Painel;
import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Robo robo = new Robo(Color.GREEN);


        int x, y;

        Scanner scanner = new Scanner(System.in);

        System.out.println("###################################");
        System.out.println("###################################");
        System.out.println("#######  Bem vindo ao Robô  #######");
        System.out.println("###################################");
        System.out.println("###################################");
        System.out.println();

        x = pegarCoordenada("Digite a Posição do Alimento no Eixo X entre 0 e 4:");

        y = pegarCoordenada("Digite a Posição do Alimento no Eixo Y entre 0 e 4:");


        Alimento alimento = new Alimento(x * AtrRobo.SIZE, y * AtrRobo.SIZE);

        JFrame frame = new JFrame("Bem vindo ao Robô");
        frame.setContentPane(new Painel(robo, alimento));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setPreferredSize(new Dimension(Painel.WIDTH + 10, Painel.WIDTH + 10));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    public static int pegarCoordenada(String msg) {
        Scanner scanner = new Scanner(System.in);
        int posicao;
        System.out.println(msg);
        try {
            posicao = scanner.nextInt();
            if (posicao < 0 || posicao > 4) throw new IllegalArgumentException();
        } catch (InputMismatchException e) {
            System.err.println("A posição digitada não é um número inteiro.");
            posicao = pegarCoordenada(msg);
        } catch (IllegalArgumentException e) {
            System.err.println("A posição digitada não está entre 0 e 4.");
            posicao = pegarCoordenada(msg);
        }
        return posicao;
    }

}
