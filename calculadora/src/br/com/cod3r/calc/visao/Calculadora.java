package br.com.cod3r.calc.visao;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Calculadora extends JFrame {

    public Calculadora(){ //construtor de inicialização da calculadora
        organizarLayout();

        setSize(232, 322);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);

    }

    private void organizarLayout() { //metodo para organizar os layout
        setLayout(new BorderLayout()); //BorderLayout é um gerenciador de tela, que define a tela como norte e sul
        Display display = new Display();

        // Configura o tamanho preferencial do componente de exibição (display) usando o método setPreferredSize().
        // A classe Dimension é utilizada para definir as dimensões desejadas.
        display.setPreferredSize(new Dimension(233, 60));
        add(display, BorderLayout.NORTH); //OBS esse add(); é um metodo vindo do extends, ele aceita dois parametros

        Teclado teclado = new Teclado();

        //os dois parametros recebidos são cores, e depois localizacão
        add(teclado, BorderLayout.CENTER); // < -- add(CORDEFUNDO, LOCALIZAÇÃO)

    }

    //COMPILADOR SERÁ CHAMADO AQUIII
    public static void main(String[] args) {
        new Calculadora();
    }


}
