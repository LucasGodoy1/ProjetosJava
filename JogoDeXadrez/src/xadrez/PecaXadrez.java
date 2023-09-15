package xadrez;

import tabuleirojogo.Pecas;
import tabuleirojogo.Tabuleiro;

public class PecaXadrez extends Pecas{
	private Cor cor;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}


	
	
	
	

}
