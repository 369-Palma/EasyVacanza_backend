package com.palma.gestioneeasyvacanza.configuration;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
		
		Difficolta difficolta = Difficolta.DifficoltaRandom() ;
		List<Vacanza> vacanze = new ArrayList<>();
		vacanze.add(vacanzaService.getVacanzaRandom());
		List<Testimonianza> testimonianze = new ArrayList<>();
		testimonianze.add(testimonianzaService.getTestimonianzaRandom());
		return Attivita.builder()
				.descrizione("Imperdibile " + TipoAttivita.TipoAttivitaRandom()  + ". Livello di difficoltà: " + difficolta)
				.difficolta(difficolta)
				.vacanze(vacanze)
				.testimonianze(testimonianze)
				.build();
	}
	
}
