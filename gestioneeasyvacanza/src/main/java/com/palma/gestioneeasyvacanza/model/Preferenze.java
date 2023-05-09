package com.palma.gestioneeasyvacanza.model;

import java.util.Locale;

import com.github.javafaker.Faker;

public enum Preferenze {
	ACCESSIBILITA_DISABILI,
	PET_FIRNDLY,
	FAMIGLIE;
	
	public static Preferenze PreferenzaRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		int size = Preferenze.values().length;
		int position = fake.number().numberBetween(0, size);
		return Preferenze.values()[position];
	}
}
