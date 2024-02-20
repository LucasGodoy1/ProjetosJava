package tela;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PainelDeBotoes extends JPanel {
    private final Color COR_ROXO = new Color(43, 9, 97);
    private final Color COR_ROXO_ESCURO = new Color(13, 3, 31);

    public PainelDeBotoes(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constrain = new GridBagConstraints();
        constrain.weightx = 1;
        constrain.weighty = 1;


        setLayout(layout);

        constrain.gridwidth =3;


        setBackground(COR_ROXO_ESCURO);
        add(new Botoes("Login", COR_ROXO), constrain, 0);

        add(new Botoes("Cadastrar", COR_ROXO),constrain, 0 );
        setPreferredSize(new Dimension(50, 50));

    }

}
