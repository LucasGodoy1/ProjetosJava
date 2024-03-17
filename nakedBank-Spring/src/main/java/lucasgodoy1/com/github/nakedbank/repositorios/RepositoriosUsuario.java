package lucasgodoy1.com.github.nakedbank.repositorios;

import lucasgodoy1.com.github.nakedbank.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta anotação define um repositório para a entidade Usuario, permitindo operações de acesso a dados.

public interface RepositoriosUsuario extends JpaRepository<Usuario, Long> {

}
