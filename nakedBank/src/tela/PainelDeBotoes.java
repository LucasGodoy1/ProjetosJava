package tela;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PainelDeBotoes extends JPanel {
    private final Color COR_ROXO = new Color(43, 9, 97);
    private final Color COR_ROXO_ESCURO = new Color(13, 3, 31);

    public PainelDeBotoes(){
        setLayout(new FlowLayout());
        setBackground(COR_ROXO_ESCURO);
        add(new Botoes("Login", COR_ROXO));

        add(new Botoes("Cadastrar", COR_ROXO));
        setPreferredSize(new Dimension(50, 50));

    }

}
