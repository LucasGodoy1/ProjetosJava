// essa é uma classe de configuração para instanciar o banco de dados
package com.educandoweb.cuorse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.cuorse.entities.User;
import com.educandoweb.cuorse.repositories.UserRepository;

	@Configuration //@Configuration sinaliza que estamos em uma classe de configuração
	@Profile("test") //@Profile podemos definir que seja rodado a config somento quando estivermos no perfil test
	public class TestConfig implements CommandLineRunner{ //CommandLineRunner é uma interface necessaria para o metodo abaixo
		
		@Autowired
		private UserRepository userRepository; //atributo da classe

		@Override
		public void run(String... args) throws Exception { //tudo que for colocado nesse metodo será executando ao iniciar o programa 

			User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
			User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
			
			userRepository.saveAll(Arrays.asList(u1, u2));
					
		}
	

}
