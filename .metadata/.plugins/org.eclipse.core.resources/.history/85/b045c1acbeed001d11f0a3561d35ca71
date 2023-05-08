package com.palma.gestioneeasyvacanza.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import com.palma.gestioneeasyvacanza.model.Cliente;
import com.github.javafaker.Faker;
@Configuration

public class ClienteConfiguration {
	
	@Bean("ClienteRandom")
	@Scope("prototype")
	public Cliente clienteRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Cliente.builder()
				.nome(fake.name().firstName())
				.cognome(fake.name().lastName())
				.email(fake.internet().emailAddress())
				.age(fake.number().numberBetween(1, 99))
				.build();
	}		
	
}
