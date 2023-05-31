package com.palma.gestioneeasyvacanza.model;

import java.util.Locale;

import com.github.javafaker.Faker;

public enum TipologiaLuogo {
	mare,
	montagna,
	foresta,
	campagna,
	metropoli;
	
	public static TipologiaLuogo TipoLuogoRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		int size = TipologiaLuogo.values().length;
		int position = fake.number().numberBetween(0, size);
		return TipologiaLuogo.values()[position];
	}
	
}
