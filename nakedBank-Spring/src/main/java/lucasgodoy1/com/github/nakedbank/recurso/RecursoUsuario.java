package lucasgodoy1.com.github.nakedbank.recurso;

import lucasgodoy1.com.github.nakedbank.entidade.Usuario;
import lucasgodoy1.com.github.nakedbank.servicos.UsuarioServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Esta classe define o controlador REST para lidar com solicitações relacionadas aos usuários do sistema.
 * A implementação atual permite recuperar todos os usuários cadastrados no sistema.
 */
@RestController
@RequestMapping(value = "/usuarios") // Define o mapeamento base para todas as solicitações neste controlador
public class RecursoUsuario {

    @Autowired
    private UsuarioServicos servico;

    @GetMapping // Mapeia solicitações HTTP GET para o método abaixo
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> lista = servico.findAll();
        return ResponseEntity.ok().body(lista); // Retorna uma resposta HTTP 200 OK com o corpo contendo os detalhes do usuário
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Usuario> findByCPF(@PathVariable Long id){
        Usuario obj = servico.findByCPF(id);
        return ResponseEntity.ok().body(obj);
    }

    /** Resutlado esperado:
     * Retorno de uma lista com todos os usuários cadastrados no sistema.
     * /@return ResponseEntity contendo uma lista de usuários e o código de status HTTP 200 OK.
     */
}
