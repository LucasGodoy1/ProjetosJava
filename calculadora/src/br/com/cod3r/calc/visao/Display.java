package br.com.cod3r.calc.visao;

import br.com.cod3r.calc.modelo.Memoria;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador{
    private final JLabel label;

    public Display() { //construtor
        //setBackground(Color.GREEN) RETORNA O FUNDO COM A COR
        //Mas nesse caso vamos usar o Color com cores em RGB como abaixo
        Memoria.getInstancia().adicionarObservador(this);
        setBackground(new Color(46, 49, 50)); //OBS setBackground(); está sendo herdado de extends
        label = new JLabel(Memoria.getInstancia().getTextoAtual());
        label.setForeground(Color.white); //cor da fonte
        label.setFont(new Font("courier", Font.PLAIN, 30)); //nome da fonte e tamanho
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));// posionamento da fonte na tela do display

        add(label);

    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }

}
