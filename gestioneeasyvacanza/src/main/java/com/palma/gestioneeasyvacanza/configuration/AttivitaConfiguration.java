package com.palma.gestioneeasyvacanza.configuration;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.palma.gestioneeasyvacanza.model.Attivita;
import com.palma.gestioneeasyvacanza.model.Difficolta;
import com.palma.gestioneeasyvacanza.model.Testimonianza;
import com.palma.gestioneeasyvacanza.model.TipoAttivita;
import com.palma.gestioneeasyvacanza.model.Vacanza;
import com.palma.gestioneeasyvacanza.service.VacanzaService;
import com.palma.gestioneeasyvacanza.service.TestimonianzaService;


@Configuration
public class AttivitaConfiguration {

	@Autowired VacanzaService vacanzaService;
	@Autowired TestimonianzaService testimonianzaService;
	
	@Bean("AttivitaRandom")
	@Scope("prototype")
	public Attivita AttivitaRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Attivita.builder()
				.descrizione("Imperdibile" + TipoAttivita.TipoAttivitaRandom()  + ". Livello di difficoltà: " + Difficolta.DifficoltaRandom())
				.difficolta(Difficolta.DifficoltaRandom())
//				.vacanze((List<Vacanza>) vacanzaService.getVacanzaRandom())
//				.testimonianze((List<Testimonianza>) testimonianzaService.getTestimonianzaRandom())
				.vacanze(null)
				.testimonianze(null)
				.build();
	}
	
}
