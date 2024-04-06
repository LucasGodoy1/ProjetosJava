package lucasgodoy1.com.github.nakedapi.service;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Usuario;
import lucasgodoy1.com.github.nakedapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    @Transactional
    public void salvar(Usuario u){
       repository.save(u);
    }

    @Transactional
    public Usuario encontrePorID(Long id){
        Usuario u = repository.findById(id).get();
        return u;
    }

    @Transactional
    public Usuario alterarSenha(Long id, String senha){
        Usuario u = encontrePorID(id);
        u.setPassword(senha);
        return u;
    }

    @Transactional
    public List<Usuario> listaDeCadastros(){
        //List<Usuario> lista = repository.findAll();
        //para diminuir futuros problemas de performance a chamada será direta sem variavel
        return repository.findAll();
    }

}
