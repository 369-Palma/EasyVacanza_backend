package com.palma.gestioneeasyvacanza.model;

import java.util.Locale;

import com.github.javafaker.Faker;

public enum TipoAlloggio {
	HOTEL,
	BUNGALOW,
	TENDA,
	CAMPEGGIO_ATTREZZATO,
	APPARTAMENTO;
	
	public static TipoAlloggio AlloggioRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		int size = TipoAlloggio.values().length;
		int position = fake.number().numberBetween(0, size);
		return TipoAlloggio.values()[position];
	}
}
