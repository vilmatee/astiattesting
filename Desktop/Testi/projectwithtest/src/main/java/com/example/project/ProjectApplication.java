package com.example.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.project.domain.Astia;
import com.example.project.domain.AstiaRepository;
import com.example.project.domain.Category;
import com.example.project.domain.CategoryRepository;
import com.example.project.domain.User;
import com.example.project.domain.UserRepository;



@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AstiaRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			//Luodaan kategoriat astioille
			crepository.save(new Category("Mukit"));
			crepository.save(new Category("Lautaset"));
			crepository.save(new Category("Kulhot"));
			crepository.save(new Category("Muut"));
			
			//Luodaan astioita
			Astia a1 = new Astia("Räsymatto", "Mustavalkoinen","4 dl", 24.00, 2018, crepository.findByName("Mukit").get(0));
			Astia a2 = new Astia("Siirtolapuutarha", "Mustavalkoinen","4 dl", 24.00, 2018, crepository.findByName("Mukit").get(0));
			Astia a3 = new Astia("Kestit", "Vaaleanpunainen","2,5 dl", 17.95, 2019, crepository.findByName("Lautaset").get(0));
			
			//Tallennetaan astiat
			repository.save(a1);
			repository.save(a2);
			repository.save(a3);
			
		//Luodaan käyttäjiä, määritetään niiden salasanat (hash), ja määritetään niiden oikeudet
		User user1 = new User("user", "$2a$10$hbzTguGsymIbJ79hnnSJCuOVobdH6pNvem7rlAo008R1Bhh3GuIVS", "USER");
		User user2 = new User("admin", "$2a$10$0QVwv4j29k2wnIeXyAoyx.dn769J8yJJjsI2C7joZ3qff/14O9o2e", "ADMIN");
		User user3 = new User("Vilma", "$2a$10$PMUZ3BOOw1wh3AKCaghdpu7jrDg.9fsrel4Z.ZCaKL/9TydPB/QX6", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		urepository.save(user3);
		
		};
	}
	
}

