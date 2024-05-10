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
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @PostMapping("/createlista")
    public ResponseEntity<List<Usuario>> createlista(@RequestBody List<Usuario> usuarios){
        usuarioService.salvarVarios(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarios);
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
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/usuariosCadastrados")
    public ResponseEntity<List<Usuario>> cadastro(){
        List<Usuario> l = usuarioService.listaDeCadastros();
        l.forEach(usuario -> usuario.setPassword("******"));
        return ResponseEntity.ok().body(l);
    }

    @DeleteMapping("/deleteID={id}")
    public ResponseEntity<Usuario> deletarPorID(@PathVariable Long id){
        usuarioService.deletePorID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }






}
