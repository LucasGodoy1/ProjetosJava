package lucasgodoy1.com.github.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") Integer numero,
                            @JsonAlias("imdbRating") String avaliacao,
                            @JsonAlias("Released") String dataDeLancamento) {

    @Override
    public String toString() {
        return "Dados Episodio" +
                "\nTitulo: " + titulo +
                "\nNumero: " + numero +
                "\nAvaliacao: " + avaliacao +
                "\nData Lançamento: " + dataDeLancamento;
    }
}
