package LucasGodoy1.com.github;

import LucasGodoy1.com.github.service.Encontre;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        try {

        boolean continuar = true;

        System.out.println("Digite o Caminho do seu Arquivo: ");
        String caminho = sc.next();
        sc.nextLine();

        Encontre encontre = new Encontre(caminho);

        do {
            System.out.println("Digite o nome da vaga desejada (ou 'F' para sair): ");
            String vaga = sc.nextLine();

            System.out.println("Processando....");
            if (vaga.equalsIgnoreCase("f")) {
                continuar = false;
            } else {
                var vagasEncontradas = encontre.IniciarBusca(vaga);
                System.out.println("Resultados Encontrados: " + vagasEncontradas.size());
                vagasEncontradas.forEach(System.out::println);
            }


        } while (continuar);
            }catch (IllegalArgumentException | IOException | InterruptedException e){
                System.out.println("Erro!! " + e);
            }

        sc.close();

    }
}
