package br.com.cod3r.calc.visao;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Display extends JPanel {
    private final JLabel label;

    public Display() { //construtor
        //setBackground(Color.GREEN) RETORNA O FUNDO COM A COR
        setBackground(new Color(46, 49, 50)); //OBS setBackground(); está sendo herdado de extends
        label = new JLabel("1234,56");
        add(label);

    }


}
