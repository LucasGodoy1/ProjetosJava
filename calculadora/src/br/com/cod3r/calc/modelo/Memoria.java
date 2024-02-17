package br.com.cod3r.calc.modelo;

import br.com.cod3r.calc.visao.MemoriaObservador;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
    private static final Memoria instancia = new Memoria();
    private String textoAtual = "";
    private final List<MemoriaObservador> observadores = new ArrayList<>();


    private Memoria(){

    }
    public void adicionarObservador(MemoriaObservador observador){
        observadores.add(observador);
    }


    public static Memoria getInstancia(){
        return instancia;
    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    public void processarComando(String valor){
        if ("AC".equals(valor)){
            textoAtual = "";
        }else{

        textoAtual += valor;
        }
        observadores.forEach(o -> o.valorAlterado(getTextoAtual()));

    }


}
