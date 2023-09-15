package tabuleirojogo;

public class Pecas {
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Pecas(Tabuleiro tabuleiro) {

		this.tabuleiro = tabuleiro;
		this.posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	
	
	

}
