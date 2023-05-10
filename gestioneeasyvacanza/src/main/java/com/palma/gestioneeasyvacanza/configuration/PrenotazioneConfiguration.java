package com.palma.gestioneeasyvacanza.configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.palma.gestioneeasyvacanza.model.Cliente;
import com.palma.gestioneeasyvacanza.model.Prenotazione;
import com.palma.gestioneeasyvacanza.model.StatoPrenotazione;
import com.palma.gestioneeasyvacanza.service.ClienteService;
import com.palma.gestioneeasyvacanza.service.VacanzaService;

@Configuration
public class PrenotazioneConfiguration {

	@Autowired ClienteService clienteService;
	@Autowired VacanzaService vacanzaService;
	@Bean("PrenotazioneRandom")
	@Scope("prototype")
	public Prenotazione PrenotazioneRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Prenotazione.builder()
				.numeroprenotazione(fake.number().numberBetween(0000000000l, 9999999999l))
				.dataprenotazione(LocalDate.of(fake.number().numberBetween(2022, 2023),fake.number().numberBetween(1, 12), fake.number().numberBetween(1, 28)))
				.numerospiti(fake.number().numberBetween(1, 20))
				.stato(StatoPrenotazione.StatoRandom())
				.vacanza(vacanzaService.getVacanzaRandom())
				//.clienti((List<Cliente>) clienteService.getClienteRandom())
				.clienti(null)
				.build();
	}
	
}
