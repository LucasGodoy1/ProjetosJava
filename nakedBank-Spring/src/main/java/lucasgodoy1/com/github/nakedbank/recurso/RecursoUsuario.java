package lucasgodoy1.com.github.nakedbank.recurso;

import lucasgodoy1.com.github.nakedbank.entidade.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta classe define o controlador REST para lidar com solicitações relacionadas aos usuários do sistema.
 * A implementação atual permite recuperar todos os usuários cadastrados no sistema.
 */
@RestController
@RequestMapping(value = "/usuarios") // Define o mapeamento base para todas as solicitações neste controlador
public class RecursoUsuario {

    @GetMapping // Mapeia solicitações HTTP GET para o método abaixo
    public ResponseEntity<Usuario> findAll(){
        Usuario u = new Usuario(123123L,"lucas", "godoy", "lucas@gmail.com",  "3323433", "1234");
        return ResponseEntity.ok().body(u); // Retorna uma resposta HTTP 200 OK com o corpo contendo os detalhes do usuário
    }
    /** Resutlado esperado:
     * Retorno de uma lista com todos os usuários cadastrados no sistema.
     * /@return ResponseEntity contendo uma lista de usuários e o código de status HTTP 200 OK.
     */
}
