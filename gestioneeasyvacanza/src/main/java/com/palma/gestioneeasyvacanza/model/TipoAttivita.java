package com.palma.gestioneeasyvacanza.model;

import java.util.Locale;

import com.github.javafaker.Faker;

public enum TipoAttivita {
	Escursione,
	Arrampicata,
	Esplorazione,
	Canottaggio,
	Degustazione;
	
	
	public static TipoAttivita TipoAttivitaRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		int size = TipoAttivita.values().length;
		int position = fake.number().numberBetween(0, size);
		return TipoAttivita.values()[position];
	}
	
}
