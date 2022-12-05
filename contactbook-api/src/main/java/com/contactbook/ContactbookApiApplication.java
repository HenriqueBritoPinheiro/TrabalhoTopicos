package com.contactbook;

import com.contactbook.entity.Contact;
import com.contactbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class ContactbookApiApplication {

	/*@Bean
	public CommandLineRunner run(@Autowired ContactRepository repository) {
		return args -> {
			Contact contact = new Contact();
			contact.setNameContact("Tiago");
			contact.setEmailContact("tiago@teste.com");
			contact.setFavoriteContact(false);
			repository.save(contact);
		};

		return args -> {
			Contact contact = Contact.builder().
					nameContact("Sofia").
					emailContact("sofia@teste.com").
					favoriteContact(true).
					build();
			repository.save(contact);
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ContactbookApiApplication.class, args);
	}

}