package visao;

import modelo.Tabuleiro;

import javax.swing.*;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

    //Construtor da classe
    public TelaPrincipal(){ //assim que o construtor for chamado ele irá executar tudo
        Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);
        add(new PainelTabuleiro(tabuleiro));

        setTitle("Campo Minado");
        setSize(690,438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();


    }

}
