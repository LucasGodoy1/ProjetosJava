package xadrez;

import tabuleirojogo.Pecas;
import tabuleirojogo.Posicao;
import tabuleirojogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		configInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i =0 ; i < tabuleiro.getLinhas() ; i++) {
			for (int j = 0 ; j < tabuleiro.getColunas() ; j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
		
	}
	
	public PecaXadrez performaMovendoXadrez(XadrezPosicao posicaoOrigem, XadrezPosicao posicaoDestino) {
		Posicao origem = posicaoOrigem.aPosicao();
		Posicao destino = posicaoDestino.aPosicao();
		validacaoPosicaoOrigem(origem);
		Pecas capturaPeca = facaMover(origem, destino);
		return (PecaXadrez)capturaPeca;
	}
	private void validacaoPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.laEstaPeca(posicao)) {
			throw new xadrezException("Nao existe peca na posicao de origem");
		}
	}
	private Pecas facaMover(Posicao origem, Posicao destino) {
		Pecas p = tabuleiro.removePecas(origem);
		Pecas pecaCapturada = tabuleiro.removePecas(destino);
		tabuleiro.lugarPeca(p, destino);
		return pecaCapturada;
	}
	
	
	private void novoLugarPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.lugarPeca(peca, new XadrezPosicao(coluna, linha ).aPosicao());
		
	}
	
	private void configInicial() {
				
		novoLugarPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		novoLugarPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		novoLugarPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	
		
	}
	
	

}
