package br.com.cod3r.calc.visao;

@FunctionalInterface
public interface MemoriaObservador{

    public void valorAlterado(String novoValor); //todos os metodos em interface são publicos.
}
