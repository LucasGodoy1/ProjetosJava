package tela;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

@SuppressWarnings("serial")
    public TelaInicial() { //tela sendo criada, abaixo as coisas sendo adicionadas a tela


        setSize(300,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        add(new PainelDeBotoes());

        setVisible(true);

    }
    public void organizarLayout(){

    }


    public static void main(String[] args) {
        new TelaInicial();
    }

}

