//esse é nosso recurso web correpondente a entidade User
//esse recurso irá disponibilizar dois end points para recuperar os usuarios cadastrados
//e tambem um usuario retornando o ID dele.
package com.educandoweb.cuorse.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cuorse.entities.User;

@RestController //controlador REST que responde no caminho /users
@RequestMapping(value = "/users")//Definindo o caminho para o recurso, nesse caso o recurso se refere A "Users"
public class UserResource {
	
	//ResponseEntity é uma tipo especifico do spring para retornar respostas de requisições WEB
	@GetMapping 
	public ResponseEntity<User> findAll(){ //método para acessar os Usuarios
		User u = new User(1L, "Maria", "Maria@gmail.com", "9999999", "1234");
		return ResponseEntity.ok().body(u); //ResponseEntity.ok para retornar a resposta com sucesso
		//em seguida usaremos o body(OBJETO); para retornar o corpo do objeto 
	}
}
