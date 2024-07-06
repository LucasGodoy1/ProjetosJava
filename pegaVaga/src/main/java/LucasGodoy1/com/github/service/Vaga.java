package LucasGodoy1.com.github.service;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
    private String site;
    private List<String> titulo = new ArrayList<>();

    public Vaga(String site) {
        this.site = site;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<String> getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo.add(titulo);
    }

    public void setTitulo(List<String> titulos) {
        this.titulo.addAll(titulos);
    }

    @Override
    public String toString() {
        return "Site: " + site + "\n" +
                "Vagas:\n\n " + String.join("\n\n ", titulo);
    }
}
