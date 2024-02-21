//esse é nosso recurso web correpondente a entidade User
//esse recurso irá disponibilizar dois end points para acessar os usuarios cadastrados
//e retornar um usuario pelo ID dele.
package com.educandoweb.cuorse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cuorse.entities.User;
import com.educandoweb.cuorse.services.UserService;

@RestController //controlador REST que responde no caminho /users
@RequestMapping(value = "/users")//Definindo o caminho para o recurso, nesse caso o recurso se refere A "Users"
public class UserResource {
	
	@Autowired
	private UserService service; 
	
	//ResponseEntity é uma tipo especifico do spring para retornar respostas de requisições WEB
	@GetMapping 
	public ResponseEntity<List<User>> findAll(){ //método para retornar os Usuarios
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //ResponseEntity.ok para retornar a resposta com sucesso
		//em seguida usaremos o body(OBJETO); para retornar o corpo do objeto 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
