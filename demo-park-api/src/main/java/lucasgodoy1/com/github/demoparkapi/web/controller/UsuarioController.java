package lucasgodoy1.com.github.demoparkapi.web.controller;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.demoparkapi.entity.Usuario;
import lucasgodoy1.com.github.demoparkapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> create(@PathVariable Long id){
        Usuario user = usuarioService.buscarPorID(id);
        return ResponseEntity.ok().body(user);
    }

    @PatchMapping("/alterarSenha={id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok().body(user);
    }



}
