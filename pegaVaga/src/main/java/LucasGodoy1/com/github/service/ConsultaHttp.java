package LucasGodoy1.com.github.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public abstract class ConsultaHttp {
    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static String buscaVaga(String palavra, String site) {
        if (!site.startsWith("http://") && !site.startsWith("https://")) {
            throw new IllegalArgumentException("URL inválido: " + site);
        }

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(site))
                    .build();

            HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

            String resultado = resposta.body();

            if (resultado != null) {
                Document doc = Jsoup.parse(resultado);
                Elements elements = doc.select("ul[data-testid='job-list__list'] li[data-testid='job-list__listitem']");

                List<String> vagas = elements.stream()
                        .map(element -> element.select("div.sc-f5007364-4").text())
                        .filter(text -> !text.isEmpty() && text.toLowerCase().contains(palavra))
                        .toList();

                if (!vagas.isEmpty()) {
                    var vagaEncontrada = new Vaga(site);
                    vagas.forEach(vagaEncontrada::setTitulo);
                    return vagaEncontrada.toString();
                } else {
                    Elements elementsContainingWord = doc.body().select("*:contains(" + palavra + ")");
                    if (!elementsContainingWord.isEmpty()) {
                        var vagaEncontrada = new Vaga(site);
                        String vaga = "⚠️Foi encontrado a vaga " + "'" + palavra +"'" + " no site acima, mas não foi possível coletar o nome⚠️️";
                        vagaEncontrada.setTitulo(vaga);
                        return vagaEncontrada.toString();
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("ERRO NA URL!! " + site + e);
        }
        return "";
    }

}
