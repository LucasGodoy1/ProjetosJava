package visao;

import modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

    //Construtor
    public PainelTabuleiro(Tabuleiro tabuleiro) {
        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        int total = tabuleiro.getLinhas() * tabuleiro.getColunas();

        for (int i = 0; i < total; i++) {
            add(new BotaoCampo(null));
        }

        tabuleiro.paraCadaCada(c -> add(new BotaoCampo(c)));
        tabuleiro.registrarObservador(e ->{
            //TODO mostrar resultado pro usuario

            tabuleiro.reiniciar();
        });

    }
}
