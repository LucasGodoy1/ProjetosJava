package lucasgodoy1.com.github.demoparkapi.service;



import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.demoparkapi.entity.Usuario;
import lucasgodoy1.com.github.demoparkapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorID(Long id){
        return usuarioRepository.findById(id).get();

    }


    @Transactional
    public Usuario editarSenha(Long id, String password) {
        Usuario user = buscarPorID(id);
        user.setPassword(password);
        return user;
    }
}
