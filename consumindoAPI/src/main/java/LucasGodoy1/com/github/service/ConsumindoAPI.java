package LucasGodoy1.com.github.service;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import LucasGodoy1.com.github.entity.Conta;

public class ConsumindoAPI {

    HttpClient client = HttpClient.newHttpClient();
    Gson gson = new Gson();

    public String getDados(String cpf) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://192.168.1.5:8080/api/v1/nakedBank/buscarID=" + cpf))
                .build();

        HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());
        return resposta.body();
    }

    public String createUser(Conta conta) throws IOException, InterruptedException {
        String json = gson.toJson(conta); //serializa o objeto para json

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://192.168.1.5:8080/api/v1/nakedBank/create"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (resposta.body() != null){
            return "Criado com SUCESSO!";
        }
        return "ALGO DEU ERRADO NÃO FOI POSsIVEL CADASTRAR";
    }
}
