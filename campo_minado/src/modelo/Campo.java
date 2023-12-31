package modelo;

import java.util.ArrayList;
import java.util.List;

import excecao.ExplosaoException;

public class Campo {
	private final int linha;
	private final int coluna;
	
	//padrao do tipo primitivo boolen começa falso
	private boolean aberto; //false
	private boolean minado; //false
	private boolean marcado; //false
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	public Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = this.linha != vizinho.linha;
		boolean colunaDiferente = this.coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		
		if (deltaGeral ==1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if (deltaGeral ==2  && diagonal ) {
			vizinhos.add(vizinho);
			return true;
		}else {
			return false;
		}
		
	}
	public void alternarMarcado() {
		if (!aberto) {
			marcado = !marcado;
		}
	}
	public Boolean abrir() {
		if (!aberto && !marcado) {
			aberto = true;
			if (minado) {
				throw new ExplosaoException();
			}
			if (vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		} else {
			return false;
		}
	}
	public boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	void minar() {
		minado = true;
	}
	public boolean isAberto() {
		return aberto;
	}
	public boolean isFechado() {
		return !isAberto();
	}
	
	
	
	
	

}
