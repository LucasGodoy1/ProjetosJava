package xadrez;

import tabuleirojogo.Posicao;

public class XadrezPosicao {

	private char coluna;
	private int linha;
	
	
	public XadrezPosicao(char coluna, int linha ) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
		    throw new xadrezException("Erro na posição do xadrez: valores válidos A1 até H8");
		}

		this.coluna = coluna;
		this.linha = linha;
	}
	

	
	
	public char getColuna() {
		return coluna;
	}


	public int getLinha() {
		return linha;
	}


	protected Posicao aPosicao() {
		return new Posicao(8 - linha,coluna - 'a');
		
	}
	protected static XadrezPosicao dePosicao(Posicao posicao) {
		return new XadrezPosicao((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}




	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
	
	
	
	
	
}
