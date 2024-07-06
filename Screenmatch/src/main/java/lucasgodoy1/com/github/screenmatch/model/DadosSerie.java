package lucasgodoy1.com.github.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {

    @Override
    public String toString() {
        return "DadosSerie: " +
                "\nTitulo: " + titulo +
                "\nTotal de Temporadas: " + totalTemporadas +
                "\nAvaliacao: " + avaliacao;
    }
}
