package LucasGodoy1.com.github.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Encontre {
    private List<String> sites = new ArrayList<>();
    private String arquivo;
    private List<String> vagasEncontradas;
    private List<Integer> indiceDoErro = new ArrayList<>();
    private Integer indice = 0;


    public Encontre(List<String> sites) {
        this.sites = sites;
    }


    public Encontre(String arquivo) {
        this.arquivo = arquivo;
    }


    public List<String> converteArquivoEmLista() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                sites.add(linha);
            }
        }catch (FileNotFoundException e){
            System.out.println("O ARQUIVO NÃO FOI ENCONTRADO! " + e);
        }
        return sites;
    }

    public List<String> IniciarBusca(String suaBusca) throws IOException, InterruptedException {
        List<String> resultados = new ArrayList<>();
        List<String> listaConvertida = converteArquivoEmLista();

        for (String link : listaConvertida) {
            indice++;
            if (link.isEmpty()){
                indiceDoErro.add(indice);
            }
            if (!link.isEmpty()) {
                String achou = ConsultaHttp.buscaVaga(suaBusca, link);
                if (!achou.isEmpty()) {
                    resultados.add(achou);
                }
            }
        }
        return resultados;

    }


    public List<Integer> getIndiceDoErro() {
        return indiceDoErro;
    }
}
