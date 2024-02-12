package aplicacao;

import modelo.Tabuleiro;
import visao.TabuleiroConsole;

public class Main {

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);

		
		
		
	}

}
