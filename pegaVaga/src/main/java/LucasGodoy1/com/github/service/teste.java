package LucasGodoy1.com.github.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;


public class teste {
    public static void main(String[] args) throws IOException, InterruptedException {

        var e = new Encontre();
        List<String> vagasEncontradas = e.iniciarBusca("estágio");
        System.out.println("Resultados enconttrados: " + vagasEncontradas.size());
        vagasEncontradas.forEach(System.out::println);

//        HttpClient client = HttpClient.newBuilder()
//                .connectTimeout(Duration.ofSeconds(10))
//                .build();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://bluesoft.com.br/carreiras/"))
//                .build();
//        var resposta = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(resposta.body());
//

    }
}
