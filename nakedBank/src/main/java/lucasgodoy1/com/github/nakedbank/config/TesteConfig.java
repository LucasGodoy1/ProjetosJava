package lucasgodoy1.com.github.nakedbank.config;

import lucasgodoy1.com.github.nakedbank.entidade.Usuario;
import lucasgodoy1.com.github.nakedbank.repositorios.RepositoriosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

// Esta classe de configuração é utilizada apenas no perfil "test" e executa algumas ações ao iniciar a aplicação.
//No Spring Boot, você pode definir o perfil que deseja ativar durante a inicialização da aplicação por meio do arquivo "spring.profiles.active"
@Configuration
@Profile("test") // Esta anotação ativa esta configuração apenas no perfil "test".
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private RepositoriosUsuario repositoriosUsuario;

    // Ao iniciar a aplicação, este método executa algumas ações para popular o banco de dados de teste.
    @Override
    public void run(String... args) throws Exception {
        // Criação de usuários de teste
        Usuario u1 = new Usuario(35665426834L,"lucca", "godoy", "lucca@gmail.com",  "3323433", "1234");
        Usuario u2 = new Usuario(76445984207L,"leticia", "godoy", "leticia@gmail.com",  "3323433", "1234");
        // Salva os usuários no banco de dados
        repositoriosUsuario.saveAll(Arrays.asList(u1, u2));
    }
}