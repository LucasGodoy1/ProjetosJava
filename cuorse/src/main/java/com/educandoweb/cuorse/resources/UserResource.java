//esse é nosso recurso web correpondente a entidade User
//esse recurso irá disponibilizar 2 end points para recuperar os usuarios cadastrados
//e tabem um usuario retornando o ID dele.
package com.educandoweb.cuorse.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cuorse.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "Maria@gmail.com", "9999999", "1234");
		return ResponseEntity.ok(u);
	}
}
