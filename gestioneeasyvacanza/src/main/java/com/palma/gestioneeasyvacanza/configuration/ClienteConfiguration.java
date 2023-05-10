package com.palma.gestioneeasyvacanza.configuration;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.palma.gestioneeasyvacanza.model.Cliente;
import com.palma.gestioneeasyvacanza.model.Prenotazione;
import com.palma.gestioneeasyvacanza.model.Testimonianza;
import com.palma.gestioneeasyvacanza.service.PrenotazioneService;
import com.palma.gestioneeasyvacanza.service.TestimonianzaService;
import com.github.javafaker.Faker;

@Configuration
public class ClienteConfiguration {
	
	@Autowired PrenotazioneService prenotazioneService;
	@Autowired TestimonianzaService testimonianzaService;
	
	@Bean("ClienteRandom")
	@Scope("prototype")
	public Cliente clienteRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		List<Prenotazione> prenotazioni = new ArrayList<>();
		prenotazioni.add(prenotazioneService.getPrenotazioneRandom());
		
		List<Testimonianza> testimonianza =new ArrayList<>();
		testimonianza.add(testimonianzaService.getTestimonianzaRandom());
		return Cliente.builder()
				.nome(fake.name().firstName())
				.cognome(fake.name().lastName())
				.email(fake.internet().emailAddress())
				.age(fake.number().numberBetween(18, 99))
				.prenotazioni(prenotazioni)
				.testimonianze(testimonianza)
				.build();
	}		
	
}
