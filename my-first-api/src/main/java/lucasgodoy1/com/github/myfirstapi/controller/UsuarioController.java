package lucasgodoy1.com.github.myfirstapi.controller;

import lucasgodoy1.com.github.myfirstapi.model.Usuario;
import lucasgodoy1.com.github.myfirstapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Usuario> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public Usuario getOne(@PathVariable String name){
        return userRepository.findByUsername(name);
    }

    @DeleteMapping("/delete={id}")
    public void delete(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

    @PostMapping
    public void postUser(@RequestBody Usuario usuario){
        userRepository.save(usuario);
    }

    @PutMapping
    public void putUser(@RequestBody Usuario usuario){
        userRepository.save(usuario);
    }


}
