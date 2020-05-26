package org.amb;

import org.amb.entities.Roles_utilisateur;
import org.amb.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class SecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
			accountService.save(new Roles_utilisateur(null , "USER")) ;
			accountService.save(new Roles_utilisateur(null , "ADMIN")) ;

			Stream.of("user 1" , "user 2" , "user 3" , "user 4", "admin").forEach(e->{
				accountService.saveUser(e , "1234" , "1234" ) ;
			});
			accountService.addRoleToUser("admin" , "ADMIN");
		};
	}

	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}


}
