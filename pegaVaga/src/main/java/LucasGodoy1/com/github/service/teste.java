package LucasGodoy1.com.github.service;

import java.io.IOException;


public class teste {
    public static void main(String[] args) throws IOException, InterruptedException {
        Encontre e = new Encontre("D://teste.txt");
        System.out.println("processando...");

        String bsc = "suport";
        String emoji = "\uD83D\uDE80\uD83C\uDF89\uD83C\uDF8A";

        var vagasEncontradas = e.IniciarBusca(bsc);
        System.out.println("Resultados Encontrados: " + vagasEncontradas.size() + " " + emoji + " Buscado por -> " + bsc);

        vagasEncontradas.forEach(System.out::println);

        if (!e.getIndiceDoErro().isEmpty()){
            System.out.println("A URL na posição " +e.getIndiceDoErro() +  " está vazio na lista");
        }
    }
}
