package tabuleirojogo;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Pecas[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("ERRO AO CRIAR O TABULEIRO: necessario ter  ao menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Pecas[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}


	public int getColunas() {
		return colunas;
	}

	
	public Pecas peca(int linha, int coluna) {
		if (!posicaoExistente(linha, coluna)) {
			throw new TabuleiroException("Posicao nao esta no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Pecas peca(Posicao posicao) {
		if (!posicaoExistente(posicao)) {
			throw new TabuleiroException("Posicao nao esta no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	public void lugarPeca(Pecas peca, Posicao posicao) {
		if (laEstaPeca(posicao)) {
			throw new TabuleiroException("Ja existe uma peca na posicao " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	public Boolean posicaoExistente(int linha, int coluna) {
		return linha >=0 && linha < linhas && coluna >= 0 && coluna < colunas;
		
	}
	
	public Boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente(posicao.getLinha(), posicao.getColuna());
	}
	
	public Boolean laEstaPeca(Posicao posicao) {
		if (!posicaoExistente(posicao)) {
			throw new TabuleiroException("Posicao nao esta no tabuleiro");
		}
		return peca(posicao) != null;
	}
	
	
	

}
