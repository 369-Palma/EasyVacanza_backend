package com.palma.gestioneeasyvacanza.model;

import java.util.Locale;

import com.github.javafaker.Faker;

public enum Difficolta {
	FACILE,
	MODERATO,
	AVANZATO;
	
	public static Difficolta DifficoltaRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		int size = Difficolta.values().length;
		int position = fake.number().numberBetween(0, size);
		return Difficolta.values()[position];
	}
	
}
