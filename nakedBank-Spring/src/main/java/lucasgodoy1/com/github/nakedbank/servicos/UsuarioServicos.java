package lucasgodoy1.com.github.nakedbank.servicos;

import lucasgodoy1.com.github.nakedbank.entidade.Usuario;
import lucasgodoy1.com.github.nakedbank.repositorios.RepositoriosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicos {

    @Autowired
    private RepositoriosUsuario repositoriosUsuario;

    public List<Usuario> findAll(){
        return repositoriosUsuario.findAll();
    }

    public Usuario findByCPF(Long cpf){
        Optional<Usuario> obj = repositoriosUsuario.findById(cpf);
        return obj.get();
    }
}
