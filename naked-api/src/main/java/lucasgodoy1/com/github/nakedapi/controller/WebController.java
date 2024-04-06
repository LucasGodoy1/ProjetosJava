package lucasgodoy1.com.github.nakedapi.controller;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Usuario;
import lucasgodoy1.com.github.nakedapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/nakedBank")
public class WebController {
    private final UsuarioService usuarioService;

    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
    usuarioService.salvar(usuario);
    return ResponseEntity.ok().build();
    }

    @GetMapping("/dadosID={id}")
    public ResponseEntity<Usuario> dadosCompleto(@PathVariable Long id){
        Usuario u = usuarioService.encontrePorID(id);
           return ResponseEntity.ok().body(u);
    }

    @GetMapping("/buscarID={id}")
    public ResponseEntity<Usuario> buscarPorCPF(@PathVariable Long id){
    Usuario u = usuarioService.encontrePorID(id);
    u.setPassword("*****");
    return ResponseEntity.ok().body(u);
    }

    @PatchMapping("/alterarSenha/id={id}")
    public ResponseEntity<String> alterarSenha(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.alterarSenha(id, usuario.getPassword());
        String u = "Senha alterada com sucesso!!";
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @GetMapping("/usuariosCadastrados")
    public ResponseEntity<List<Usuario>> cadastro(){
        List<Usuario> l = usuarioService.listaDeCadastros();
        l.forEach(usuario -> usuario.setPassword("******"));
        return ResponseEntity.ok().body(l);
    }






}
