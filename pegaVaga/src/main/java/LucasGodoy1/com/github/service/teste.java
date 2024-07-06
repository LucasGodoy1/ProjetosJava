package LucasGodoy1.com.github.service;

import java.io.IOException;
import java.util.List;


public class teste {
    public static void main(String[] args) throws IOException, InterruptedException {

        var e = new Encontre();
        List<String> vagasEncontradas = e.iniciarBusca("atendimento");
        System.out.println("Resultados enconttrados: " + vagasEncontradas.size());
        vagasEncontradas.forEach(System.out::println);


    }
}
