package com.palma.gestioneeasyvacanza.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.palma.gestioneeasyvacanza.model.Testimonianza;
import com.palma.gestioneeasyvacanza.service.AttivitaService;
import com.palma.gestioneeasyvacanza.service.ClienteService;
import com.
github.javafaker.Faker;
@Configuration
public class TestimonianzaConfiguration {

	@Autowired ClienteService clienteService;
	@Autowired AttivitaService attivitaServ;
	
	@Bean("TestimRandom")
	@Scope("prototype")
	public Testimonianza randomTest() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Testimonianza.builder()
				.nome(fake.name().firstName())
				.cognome(fake.name().lastName())
				.email(fake.internet().emailAddress())
				.feedback(fake.lorem().paragraph(2))
				.rating(fake.number().numberBetween(0, 5))
//				.attivita(attivitaServ.getAttivitaRandom())
//				.cliente(clienteService.getClienteRandom())
				.attivita(null)
				.cliente(null)
				.build();
	}
}
