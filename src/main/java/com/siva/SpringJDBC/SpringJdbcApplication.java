package com.siva.SpringJDBC;

import com.siva.SpringJDBC.model.Alien;
import com.siva.SpringJDBC.repository.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Alien alien = context.getBean(Alien.class);
		alien.setId(4);
		alien.setName("siva");
		alien.setTech("Java Developer");

		AlienRepo alienRepo = context.getBean(AlienRepo.class);
		alienRepo.save(alien);
		System.out.println(alienRepo.findAll());


	}

}
