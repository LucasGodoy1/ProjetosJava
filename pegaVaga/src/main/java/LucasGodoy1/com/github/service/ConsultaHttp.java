package LucasGodoy1.com.github.service;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public abstract class ConsultaHttp {
    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(20))
            .build();

    public static String coletaCorpoDoSite(String site) {
        if (!site.startsWith("http://") && !site.startsWith("https://")) {
            throw new IllegalArgumentException("URL inválido: " + site);
        }

        HttpResponse<String> resposta = null;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(site))
                    .build();

            resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            System.out.println("ERRO NA URL!! " + site + e);
        }
        return resposta.body();
    }

}
