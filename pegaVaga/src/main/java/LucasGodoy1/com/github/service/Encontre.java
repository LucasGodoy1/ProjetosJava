package LucasGodoy1.com.github.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Encontre {
    private List<Integer> indiceDoErro = new ArrayList<>();
    private Integer indice = 0;


    public List<String> iniciarBusca(String suaBusca) throws IOException, InterruptedException {
        List<String> resultados = new ArrayList<>();
        List<String> listaConvertida = Conversor.converteArquivoEmLista("D://teste.txt");

        ExecutorService executorService = Executors.newFixedThreadPool(12); // Utilize um número adequado de threads
        List<Future<String>> futures = new ArrayList<>();

        for (String link : listaConvertida) {
            indice++;
            if (link.isEmpty()) {
                indiceDoErro.add(indice);
            }
            if (!link.isEmpty()) {
                futures.add(executorService.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return ConsultaHttp.buscaVaga(suaBusca, link);
                    }
                }));
            }
        }

        for (Future<String> future : futures) {
            try {
                String resultado = future.get();
                if (!resultado.isEmpty()) {
                    resultados.add(resultado);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return resultados;
    }

    public List<Integer> getIndiceDoErro() {
        return indiceDoErro;
    }
}
