package br.com.cod3r.calc.visao;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Teclado extends JPanel {

    private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
    private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
    private final Color COR_LARANJA = new Color(242, 163, 60);


    public Teclado() { //construtor
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constrain = new GridBagConstraints();

        constrain.weightx = 1;
        constrain.weighty = 1;

        constrain.fill = GridBagConstraints.BOTH; //preencher os botões para todos  os lados

        setLayout(layout);
        //linha 1
        constrain.gridwidth =3;
        adicionarBotao("AC", COR_CINZA_ESCURO, constrain, 0, 0);
        constrain.gridwidth =1;

        adicionarBotao("/", COR_LARANJA, constrain, 3, 0);
        //linha2
        adicionarBotao("7", COR_CINZA_ESCURO, constrain, 0, 1);
        adicionarBotao("8", COR_CINZA_CLARO, constrain, 1, 1);
        adicionarBotao("9", COR_CINZA_CLARO, constrain, 2, 1);
        adicionarBotao("/", COR_LARANJA, constrain, 3, 1);

        adicionarBotao("4", COR_CINZA_ESCURO, constrain, 0, 2);
        adicionarBotao("5", COR_CINZA_CLARO, constrain, 1, 2);
        adicionarBotao("6", COR_CINZA_CLARO, constrain, 2, 2);
        adicionarBotao("-", COR_LARANJA, constrain, 3, 2);

        adicionarBotao("1", COR_CINZA_ESCURO, constrain, 0, 3);
        adicionarBotao("2", COR_CINZA_CLARO, constrain, 1, 3);
        adicionarBotao("3", COR_CINZA_CLARO, constrain, 2, 3);
        adicionarBotao("+", COR_LARANJA, constrain, 3, 3);
        constrain.gridwidth = 3;//expande a constrain
        adicionarBotao("0", COR_CINZA_ESCURO, constrain, 0, 4);
        constrain.gridwidth =1; //volta ao tamanho normal

        adicionarBotao(",", COR_CINZA_CLARO, constrain, 2, 4);
        adicionarBotao("=", COR_LARANJA, constrain, 3, 4);


    }

    private void adicionarBotao(String texto, Color cor
            , GridBagConstraints c, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        Botao botao = new Botao(texto, cor);
        add(botao, c);

    }
}
