package visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import excecao.ExplosaoException;
import excecao.SairException;
import modelo.Tabuleiro;

public class TabuleiroConsole {
	//atributo do tipo tabuleiro
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	
	
	public TabuleiroConsole (Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		executarJogo();
	}


	private void executarJogo() {
		try {
			boolean continuar = true;
			while (continuar) {
				cicloDoJogo();
				System.out.println("quer iniciar outra partida? [S/n]");
				String resposta = entrada.nextLine();
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				}else {
					tabuleiro.reiniciar();
				}
			}
		}catch (SairException e) {
			System.out.println("Tchau!!");
		}finally {
			entrada.close();
		}
	}


	private void cicloDoJogo() {
		try {
			while (!tabuleiro.objetivoAlcanado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigitado("Digite x, y: ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
				.map(e -> Integer.parseInt(e.trim())).iterator();
				
				System.out.println(xy.next());
				System.out.println(xy.next());
				
				digitado = capturarValorDigitado("Digite 1 -> Abrir ou 2 -> Marcar(Des): ");
				
				if ("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(),xy.next());
				}else if("2".equals(digitado)){
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
					
			}
			System.out.println("Você ganhou!");
		}catch (ExplosaoException e) {
			System.out.println("Você perdeu");
		}
		
		
	}
	
	public String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		if ("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}
	

}
