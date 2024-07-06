package LucasGodoy1.com.github;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://bhs.gupy.io/"))
                .build();
       var resposta = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(resposta.body());

    }
}