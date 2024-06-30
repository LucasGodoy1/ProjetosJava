package LucasGodoy1.com.github.service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class ConsultaHttp {





    public static String buscaVaga(String palavra, String site) {

        if (!site.startsWith("http://") && !site.startsWith("https://")) {
            throw new IllegalArgumentException("URL inválido: " + site);
        }

        try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(site))
                .build();

        HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

        String resultado = resposta.body();

        if (resultado != null) {
            Document doc = Jsoup.parse(resultado);
            Elements elements = doc.body().select("*:contains(" + palavra + ")");

            if (!elements.isEmpty()) {
                return site;
            }
        }


        }catch (IOException | InterruptedException e){
            System.out.println("ERRO NA URL!! " + site + e);

        }
        return "";
    }
}